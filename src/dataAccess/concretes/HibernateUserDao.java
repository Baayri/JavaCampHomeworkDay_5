package dataAccess.concretes;

import dataAccess.abstracts.UserDao;
import entities.concretes.User;
import java.util.ArrayList;
import java.util.List;

public class HibernateUserDao implements UserDao {
    private static ArrayList<User> userList;

    public  HibernateUserDao(){
        userList=new ArrayList<>();
    }

    @Override
    public void add(User user) {
        System.out.println("Hibernate ile eklendi: "+user.getFirstName());
        userList.add(user);
    }

    @Override
    public void update(User user) {
        System.out.println("Bilgiler guncellendi: "+user.getFirstName());
    }

    @Override
    public void delete(User user) {
        System.out.println("Silindi: "+user.getFirstName());
    }



    @Override
    public User get(String mail) {
        for (User user:userList){
            if (user.getMail()==mail){
                return user;
            }
        }
        return null;
    }

    @Override
    public List<User> getAll() {
        if (userList==null){
            return null;
        }else {
            return userList;
        }
    }
}
