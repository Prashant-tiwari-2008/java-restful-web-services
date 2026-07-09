package com.javaStudy.rest_web_services.restful_web_services.user;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public class User {
    private String username;
    private final int ID;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
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
