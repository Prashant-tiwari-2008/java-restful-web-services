package com.javaStudy.rest_web_services.restful_web_services.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonVersionController {

    @GetMapping("/v1/person")
    public PersonV1 getFirstVersionOfPerson() {
        return new PersonV1("Pradeep tiwari - v1");
    }

    @GetMapping("/v2/person")
    public PersonV2 getSecondVersionOfPerson() {
        return new PersonV2(new Name("Prashant", "tiwari - v2"));
    }

    @GetMapping(path = "/person", headers = "X-API-VERSION=1")
    public PersonV1 getFirstVersionOfPersonRequestParamtere() {
        return new PersonV1("Pradeep tiwari - v1");
    }


    @GetMapping(path = "/person", params = "version=2")
    public PersonV2 getSecondVersionOfPersonRequestParamtere() {
        return new PersonV2(new Name("Prashant", "tiwari - v2"));
    }

    @GetMapping(path = "/person/header", headers = "X-API-VERSION=1")
    public PersonV1 getFirstVersionOfPersonWithHeader() {
        return new PersonV1("Pradeep tiwari - v1 - header");
    }


    @GetMapping(path = "/person/header", headers = "X-API-VERSION=2")
    public PersonV2 getSecondVersionOfPersonWithHeader() {
        return new PersonV2(new Name("Prashant - header", "tiwari - v2"));
    }


    @GetMapping(path = "/person/acceptHeader", produces = "application/vnd.company.app-v1+json")
    public PersonV1 getFirstVersionOfPersonWithAcceptHeader() {
        return new PersonV1("Pradeep tiwari - v1 - header");
    }


    @GetMapping(path = "/person/acceptHeader", produces = "application/vnd.company.app-v2+json")
    public PersonV2 getSecondVersionOfPersonWithAcceptHeader() {
        return new PersonV2(new Name("Prashant - header", "tiwari - v2"));
    }

}
