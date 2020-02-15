package spring.intro;

import spring.intro.config.AppConfig;

import java.util.List;

import spring.intro.model.User;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import spring.intro.service.UserService;

public class Main {
    public static void main(String[] args) {
        User user1 = new User();
        user1.setName("user1FirstName");
        user1.setEmail("user1LastName");

        User user2 = new User();
        user2.setName("user2FirstName");
        user2.setEmail("user2LastName");

        AnnotationConfigApplicationContext contex
                = new AnnotationConfigApplicationContext(AppConfig.class);
        UserService userService = contex.getBean(UserService.class);
        userService.add(user1);
        userService.add(user2);
        List<User> users = userService.listUsers();
        users.forEach(System.out::println);
    }
}
