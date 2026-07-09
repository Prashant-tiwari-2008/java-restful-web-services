package com.javaStudy.rest_web_services.restful_web_services.user;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

@Component
public class UserDaoService {
    //later => JPA/Hibernate => databse
    //Current => Static list

    private static List<User> users = new ArrayList<User>();

    // Read about static bloac
    static {
        users.add(new User("Prashant", 1, LocalDate.now().minusYears(30)));
        users.add(new User("Pradeep", 1, LocalDate.now().minusYears(40)));
        users.add(new User("Sweta", 1, LocalDate.now().minusYears(35)));
    }


    public List<User> getUsers() {
        return users;
    }

    public User setUsers(User user) {
        users.add(user);
        return user;
    }

    // todo : need to read more about it
    public User getUser(int id) {
        Predicate<? super User> predicate = user -> user.getID().equals(id);
//        return users.stream().filter(predicate).findFirst().orElse(null);
        return users.stream().filter(predicate).findFirst().orElse(null);
    }
}
