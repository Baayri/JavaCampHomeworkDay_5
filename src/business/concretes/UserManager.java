package business.concretes;

import business.abstracts.MailService;
import business.abstracts.UserService;
import business.abstracts.ValidationService;
import dataAccess.abstracts.UserDao;
import entities.concretes.User;

public class UserManager implements UserService {
    private ValidationService validationService;
    private MailService mailService;
    private UserDao userDao;

    public  UserManager(ValidationService validationService,MailService mailService,UserDao userDao){
        this.validationService=validationService;
        this.mailService=mailService;
        this.userDao=userDao;
    }

    @Override
    public void signIn(String mail,String password) {
       for (User user: userDao.getAll()){
           if (user.getMail().equals(mail) && user.getPassword().equals(password)){
               System.out.println("Giris basarili : "+user.getMail());
           }
           else {
               System.out.println("Giris basarisiz eksik veya hatali bilgi");
           }
       }
    }

    @Override
    public void signUp(User user) {
        if (!validationService.checkUser(user)){
            System.out.println("Hatali veya eksik bilgi");
            return;
        }

        for (User user1: userDao.getAll()){
            if (user1.getMail().equals(user.getMail())){
                System.out.println("Girmis olduğunuz mail kullanımda :"+user1.getMail());
                return;
            }
        }
        mailService.sendMail(user);
        System.out.println("Kayit basarili");
        userDao.add(user);
    }
}
