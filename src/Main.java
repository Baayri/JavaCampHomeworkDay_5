import business.abstracts.UserService;
import business.concretes.MailManager;
import business.concretes.UserManager;
import business.concretes.ValidationManager;
import core.GoogleAuthenticationAdapter;
import dataAccess.concretes.HibernateUserDao;
import entities.concretes.User;

public class Main {
    public static void main(String[] args) {
        UserService userService=new UserManager(new ValidationManager(),new MailManager(),new HibernateUserDao());

        User user=new User(1,"Muhammed","Bayri","muhammedbayri@gmail.com","123456");
        userService.signUp(user);
        userService.signIn("muhammedbayri@gmail.com","123456");

        System.out.println("");

        User user2=new User(1,"Muhammed","Bayri","muhammedbayri@gmail.com","1234567");
        userService.signUp(user2);

        System.out.println("");

        User user3=new User(1,"Muhammed","Bayri","muhammedbayri@gmail.com","123");
        userService.signUp(user3);

        System.out.println("");

        UserService userService1=new UserManager(new ValidationManager(),new GoogleAuthenticationAdapter(),new HibernateUserDao());
        User user4=new User(1,"M","B","muhammed@gmail.com","123456");
        userService1.signUp(user4);

        System.out.println("");

        User user5=new User(1,"Muhammed","Bayri","muhammed@gmail.com","123456");
        userService1.signUp(user5);
        userService1.signIn("muhammed@gmail.com","123456");



    }
}
