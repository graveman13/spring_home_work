import config.AppConfig;

import java.util.List;

import model.User;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import service.impl.UserService;

public class Main {
    public static void main(String[] args) {
        User user1 = new User();
        user1.setFirstName("user1FirstName");
        user1.setLastName("user1LastName");

        User user2 = new User();
        user2.setFirstName("user2FirstName");
        user2.setLastName("user2LastName");

        AnnotationConfigApplicationContext contex
                = new AnnotationConfigApplicationContext(AppConfig.class);
        UserService userService = contex.getBean(UserService.class);
        userService.add(user1);
        userService.add(user2);
        List<User> users = userService.listUsers();
        users.forEach(System.out::println);
    }
}
