package com.javaStudy.rest_web_services.restful_web_services.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//@RestController
//public class SpringBootPersonVersion {
//
////    @GetMapping(value = "{version}/personsbi", version = "1.0.0" )
////    public PersonV1 getFirstVersionOfPerson() {
////        return new PersonV1("Pradeep tiwari - v1");
////    }
////
////    @GetMapping(value = "{version}/personsbi", version = "2.0.0")
////    public PersonV2 getSecondVersionOfPerson() {
////        return new PersonV2(new Name("Prashant", "tiwari - v2"));
////    }
////
//    @GetMapping(path = "/personsbi", version = "1.0.0")
//    public PersonV1 getFirstVersionOfPersonRequestParamtere() {
//        return new PersonV1("Pradeep tiwari - v1");
//    }
//
//
//    @GetMapping(path = "/personsbi", version = "2.0.0")
//    public PersonV2 getSecondVersionOfPersonRequestParamtere() {
//        return new PersonV2(new Name("Prashant", "tiwari - v2"));
//    }
//
//    // similarly we can do with other metho
//    // we will define thing in application.properties

//}
