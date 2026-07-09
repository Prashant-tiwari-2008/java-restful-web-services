package com.javaStudy.rest_web_services.restful_web_services.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

//REST API
@RestController
public class HelloWorld {


 //Question => when in first method string return and 2nd json
    @GetMapping("/hello_world")
    public String sayHello() {
        return "Hello World!";
    }

    @GetMapping("/hello_world-bean")
    public HelloWorldBean helloWorldBean() {
        return new HelloWorldBean("Hello World!");
    }


    @GetMapping("/hello_world/path-variable/{name}")
    public HelloWorldBean helloWorldPathVariable(@PathVariable String name) {
        return new HelloWorldBean(String.format("Hello World!, %s", name));
    }

}
