package chapter17annotations;

import java.util.List;

/**
 * Created by nayanzin on 20.08.17.
 */
public class PasswordUtils {
    @UseCase(id = 47, description =
            "Passwords must contatin at least one numeric")
    public boolean validatePasseord(String password) {
        return (password.matches("\\w*\\d\\w*"));
    }

    @UseCase(id = 48)
    public String encryptPassword(String password) {
        return new StringBuilder(password).reverse().toString();
    }

    @UseCase(id = 49, description =
    "New password can't equal previously ones")
    public boolean checkForNewPassword(
            List<String> prevPasswords, String password) {
        return !prevPasswords.contains(password);
    }
}
