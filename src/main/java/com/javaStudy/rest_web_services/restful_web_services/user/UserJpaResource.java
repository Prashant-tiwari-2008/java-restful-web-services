package com.javaStudy.rest_web_services.restful_web_services.user;

import com.javaStudy.rest_web_services.restful_web_services.jpa.UserRepository;
import jakarta.persistence.Entity;
import jakarta.validation.Valid;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
public class UserJpaResource {
    private UserDaoService userService;
    private UserRepository repository;

    public UserJpaResource(UserDaoService userService, UserRepository repository) {
        this.userService = userService;
        this.repository = repository;
    }


    @GetMapping("/jpa/users")
    public List<User> retrieveAllUsers() {
        return repository.findAll();
    }


    @GetMapping("/jpa/user/{id}")
    public Optional<User> getUser(@PathVariable int id) {
        Optional<User> currentUser = repository.findById(id);
        if(currentUser.isEmpty()) {
            throw new UserNotFoundException("id : " + id);
        }
        return currentUser;
    }


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


    @PostMapping("/jpa/user")
    public ResponseEntity<User> createUser(@Valid  @RequestBody User user) {
        User savedUser = repository.save(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getID())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/jpa/user/{id}")
    public void deleteUser(@PathVariable int id) {
        repository.deleteById(id);
    }

}
