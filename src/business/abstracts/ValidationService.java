package business.abstracts;

import entities.concretes.User;

public interface ValidationService {
    boolean checkUser(User user);
}
