package business.concretes;

import business.abstracts.MailService;
import entities.concretes.User;

public class MailManager implements MailService {
    @Override
    public void sendMail(User user) {
        System.out.println("Dogrulama maili gonderildi :" + user.getMail());
    }
}
