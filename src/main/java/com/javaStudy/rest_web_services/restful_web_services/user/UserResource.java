package com.javaStudy.rest_web_services.restful_web_services.user;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserResource {
    private UserDaoService userService;

    public UserResource(UserDaoService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable int id) {
        User currentUser =  userService.getUser(id);
        System.out.printf("currentUser %s $n ", currentUser);
        return currentUser;
    }

    @PostMapping("/user")
    public void createUser(@RequestBody User user) {
        userService.setUsers(user);
    }
}
