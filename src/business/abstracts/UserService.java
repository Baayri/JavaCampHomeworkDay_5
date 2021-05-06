package business.abstracts;

import entities.concretes.User;

public interface UserService {
    void signIn(String mail,String password);
    void signUp(User user);
}
