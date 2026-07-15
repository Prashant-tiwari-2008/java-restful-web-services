package com.javaStudy.rest_web_services.restful_web_services.user;

import com.javaStudy.rest_web_services.restful_web_services.jpa.PostRepository;
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
    private PostRepository postRepository;

    public UserJpaResource(UserDaoService userService, UserRepository repository,PostRepository postRepository) {
        this.userService = userService;
        this.repository = repository;
        this.postRepository = postRepository;
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

    @GetMapping("/jpa/user/{id}/post")
    public List<Post> retrievePostForUser(@PathVariable int id) {
        Optional<User> currentUser = repository.findById(id);
        System.out.println("currentUser: " + currentUser);
        if(currentUser.isEmpty()) {
            throw new UserNotFoundException("id : " + id);
        }

       return currentUser.get().getPosts();
    }

    @PostMapping("/jpa/user/{id}/post")
    public ResponseEntity<Post> createPostForUser(@PathVariable int id, @Valid @RequestBody Post post) {
        Optional<User> currentUser = repository.findById(id);
        if(currentUser.isEmpty()){
            throw new  UserNotFoundException("id : " + id);
        }
        post.setUser(currentUser.get());
        Post saavedPost = postRepository.save(post);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(saavedPost.getId()).toUri();
        return ResponseEntity.created(location).build();
    }
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
