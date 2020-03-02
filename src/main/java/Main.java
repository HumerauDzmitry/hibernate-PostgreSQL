import models.Auto;
import models.User;
import org.apache.log4j.Logger;
import services.UserService;

import java.sql.SQLException;

public class Main {
    private final static Logger logger = Logger.getLogger(Main.class);

    public static void main(String[] args) throws SQLException {
        UserService userService = new UserService();
        User user = new User("Masha",26);
        userService.saveUser(user);
        Auto ferrari = new Auto("Ferrari", "red");
        ferrari.setUser(user);
        user.addAuto(ferrari);
        Auto ford = new Auto("Ford", "black");
        ford.setUser(user);
        user.addAuto(ford);
        userService.updateUser(user);

        userService.updateUser(user);
        user.setName("Fedya");
        userService.updateUser(user);

        logger.info(userService.findAllUsers());
        logger.info(userService.findUser(8).getName() + " - " + userService.findUser(8).getAutos());
    }
}