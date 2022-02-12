package com.example.servingwebcontent.domain;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;

    private String userName;

    private String userEmail;

    public Integer getId() {
        return id;
    }

    public User() {
    }

    public User(String userName, String email) {
        this.userName = userName;
        this.userEmail = email;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String name) {
        this.userName = name;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String email) {
        this.userEmail = email;
    }
}
