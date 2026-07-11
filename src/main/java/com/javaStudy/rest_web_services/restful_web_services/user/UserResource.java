package com.javaStudy.rest_web_services.restful_web_services.user;

import jakarta.validation.Valid;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class UserResource {
    private UserDaoService userService;

    public UserResource(UserDaoService userService) {
        this.userService = userService;
    }


    @GetMapping("/users")
    public List<User> retrieveAllUsers() {
        return userService.getUsers();
    }


//    @GetMapping("/user/{id}")
//    public User getUser(@PathVariable int id) {
//        User currentUser =  userService.getUser(id);
//        if(currentUser == null) {
//            throw new UserNotFoundException("id : " + id);
//        }
//        System.out.printf("currentUser %s $n ", currentUser);
//        return currentUser;
//    }


//  todo : not working
//    @GetMapping("/user/{id}")
//    public EntityModel<User> getUser(@PathVariable int id) {
//        User currentUser =  userService.getUser(id);
//        if(currentUser == null) {
//            throw new UserNotFoundException("id : " + id);
//        }
//        EntityModel<User> entityModel = EntityModel.of(currentUser);
//        WebMvcLinkBuilder link = linkTo(methodOn(this.getClass().retrieveAllUsers()));
//        entityModel.add(link.withRel("all-users"));
//        return entityModel;
//    }


    @PostMapping("/user")
    public ResponseEntity<User> createUser(@Valid  @RequestBody User user) {
        User savedUser = userService.setUsers(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getID())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/user/{id}")
    public String deleteUser(@PathVariable int id) {
        if(userService.deleteUser(id)) {
            return "User Deleted successfully";
        }else{
            return "NOt able to delete user";
        }

    }

}
