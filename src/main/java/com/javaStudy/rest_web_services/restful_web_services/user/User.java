package com.javaStudy.rest_web_services.restful_web_services.user;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.util.List;

@Entity(name="user_details")
@Table(name="user_details")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Size(min = 2, max = 50 , message = "Name should b/w 2 to 50 char long testing auto save setting")
    @JsonProperty("user_name")
    private String username;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @Past(message = "date should be from past only testing")
    @JsonProperty("Birth_Date")
    @Column(name = "birth_date")
    private LocalDate birthday;

    @OneToMany(mappedBy = "user")
//    @JsonIgnore
    private List<Post> posts;

    public User() {
    }
    public User(int ID, String username, LocalDate birthday) {}

    public User(String username, Integer id, LocalDate birthday) {
        super();
        this.username = username;
        this.id = id;
        this.birthday = birthday;
    }

    public Integer getID() {
        return id;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", Id='" + id + '\'' +
                ", birthday=" + birthday +
                '}';
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }
}
