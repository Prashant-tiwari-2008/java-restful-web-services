package com.javaStudy.rest_web_services.restful_web_services.versioning;

public class PersonV1 {
    private String Name;

    public PersonV1(String name) {
        super();
        Name = name;
    }
    public String getName() {
        return Name;
    }

    @Override
    public String toString() {
        return "PersonV1{" +
                "Name='" + Name + '\'' +
                '}';
    }
}
