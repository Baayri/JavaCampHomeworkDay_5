package business.concretes;

import business.abstracts.ValidationService;
import entities.concretes.User;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidationManager implements ValidationService {

    @Override
    public boolean checkUser(User user) {
        Pattern mailPattern = Pattern.compile("[a-z A-Z 0-9]+@[a-z A-Z 0-9]+\\.[a-z A-Z 0-9]+$");
        Pattern passwordPattern = Pattern.compile(".{6,}");
        Pattern firstNamePattern = Pattern.compile(".{2,}");
        Pattern lastNamePattern = Pattern.compile(".{2,}");
        Matcher mailMatcher = mailPattern.matcher(user.getMail());
        Matcher passwordMatcher = passwordPattern.matcher(user.getPassword());
        Matcher firstNameMatcher = firstNamePattern.matcher(user.getFirstName());
        Matcher lastNameMatcher = lastNamePattern.matcher(user.getLastName());
        return mailMatcher.matches() && passwordMatcher.matches() && firstNameMatcher.matches() && lastNameMatcher.matches();

    }

}
