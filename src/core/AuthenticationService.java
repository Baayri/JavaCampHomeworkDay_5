package core;

import entities.concretes.User;

public interface AuthenticationService {
    void sendMail(User user);
}
