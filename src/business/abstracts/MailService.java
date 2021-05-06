package business.abstracts;

import entities.concretes.User;

public interface MailService {
    void sendMail(User user);
}
