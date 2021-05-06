package core;

import business.abstracts.MailService;
import entities.concretes.User;
import googleAuthentication.GoogleAuthentication;

public class GoogleAuthenticationAdapter implements AuthenticationService, MailService {
    @Override
    public void sendMail(User user) {
        GoogleAuthentication googleAuthentication=new GoogleAuthentication();
        googleAuthentication.signUp(user.getMail());
    }
}
