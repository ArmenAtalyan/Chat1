
import model.User;
import service.UserService;

public class Main {

    public static void main(String[] args) {
        User user = new User();
        UserService userService = new UserService(user);
        userService.memberCall();
    }
}
