package spring.intro.controllers;

import spring.intro.UserResponseDto;
import spring.intro.model.User;
import spring.intro.service.UserService;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserContorller {
    @Autowired
    private UserService userService;

    @GetMapping(value = "/get/{userId}")
    public UserResponseDto get(@PathVariable Long userId) {
        User user = userService.get(userId);
        return new UserResponseDto(user.getName(), user.getEmail());
    }

    @GetMapping(value = "/getAll")
    public List<UserResponseDto> getAll() {
        return new ArrayList(userService.listUsers());
    }

    @GetMapping(value = "/inject")
    public void inject() {
        userService.add(new User("Howard", "Lovecraft@gmail.com"));
        userService.add(new User("Stephen", "King@gmail.com"));
        userService.add(new User("Robert", "Salvatore@gmail.com"));
        userService.add(new User("Nick", "Perumov@gmail.com"));
    }
}
