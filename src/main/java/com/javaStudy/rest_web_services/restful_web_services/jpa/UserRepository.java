package com.javaStudy.rest_web_services.restful_web_services.jpa;

import com.javaStudy.rest_web_services.restful_web_services.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {

}
