package com.javaStudy.rest_web_services.restful_web_services.helloworld;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

//REST API
@RestController
public class HelloWorld {

    private MessageSource messageSource;

    public HelloWorld(MessageSource messageSource) {
        this.messageSource = messageSource;
    }
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

    @GetMapping(path="/hello-world-internationalized")
    public String helloWorldInternationalized() {
        //step
        // 1. define message for different language
        // 2. code to pick right impl
        // 2 thing need to careful => 1. it should be in src>resources(should be in same folder as application.properties) 2. Name should be messsages.properties
        Locale locale = LocaleContextHolder.getLocale();
        return messageSource.getMessage("good.morning.message",null, "Default message",locale);
    }
}
