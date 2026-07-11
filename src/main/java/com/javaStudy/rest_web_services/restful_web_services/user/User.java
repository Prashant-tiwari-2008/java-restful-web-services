package com.javaStudy.rest_web_services.restful_web_services.user;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public class User {

    private final int ID;

    @Size(min = 2, max = 50 , message = "Name should b/w 2 to 50 char long testing auto save setting")
   @JsonProperty("user_name")
    private String username;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @Past(message = "date should be from past only testing")
    @JsonProperty("Birth_Date")
    private final LocalDate birthday;

    public User(String username, Integer id, LocalDate birthday) {
        super();
        this.username = username;
        this.ID = id;
        this.birthday = birthday;
    }

    public Integer getID() {
        return ID;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", Id='" + ID + '\'' +
                ", birthday=" + birthday +
                '}';
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
