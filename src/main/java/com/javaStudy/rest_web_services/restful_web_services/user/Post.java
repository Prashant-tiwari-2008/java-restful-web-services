package com.javaStudy.rest_web_services.restful_web_services.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String Description;

    @ManyToOne(fetch = FetchType.LAZY)
//  @JoinColumn(name = "user_id") todo : need to study
    @JsonIgnore
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        this.Description = description;
    }
}
