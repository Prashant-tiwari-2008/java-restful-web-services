package com.javaStudy.rest_web_services.restful_web_services.versioning;

public class PersonV2 {
    private Name name;

    public PersonV2(Name name) {
        super();
        this.name = name;
    }

    @Override
    public String toString() {
        return "PersonV2{" +
                "full name=" + name +
                '}';
    }

    public Name getName() {
        return name;
    }

}
