import java.util.HashSet;
import java.util.Set;

class UserAlreadyExistsException extends Exception {
    public UserAlreadyExistsException(String message) {
        super(message);
    }
}
class UserNotFoundException extends Exception {
    public UserNotFoundException(String message) {
        super(message);
    }
}
class UserService {
    private Set<String> registeredUsers;

    public UserService() {
        this.registeredUsers = new HashSet<>();
    }

    public void registerUser(String username) throws UserAlreadyExistsException {
        if (registeredUsers.contains(username)) {
            throw new UserAlreadyExistsException("User '" + username + "' already exists.");
        }
        registeredUsers.add(username);
        System.out.println("User '" + username + "' registered successfully.");
    }

    public void checkUserExistence(String username) throws UserNotFoundException {
        if (!registeredUsers.contains(username)) {
            throw new UserNotFoundException("User '" + username + "' not found.");
        }
        System.out.println("User '" + username + "' exists.");
    }
}
public class ThrowAndThrows {
    public static void main(String[] args) {
        UserService userService = new UserService();

        try {
            userService.registerUser("ayushi");

        } catch (UserAlreadyExistsException e) {
            System.err.println("Error: " + e.getMessage());
        }

        try {
            userService.checkUserExistence("aradhya");
            userService.checkUserExistence("aradhya");
        } catch (UserNotFoundException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
