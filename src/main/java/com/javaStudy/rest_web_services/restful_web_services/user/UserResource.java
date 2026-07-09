package com.javaStudy.rest_web_services.restful_web_services.user;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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
        if(currentUser == null) {
            throw new UserNotFoundException("id : " + id);
        }
        System.out.printf("currentUser %s $n ", currentUser);
        return currentUser;
    }

    @PostMapping("/user")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User savedUser = userService.setUsers(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getID())
                .toUri();

        return ResponseEntity.created(location).build();
    }
}
