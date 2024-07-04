package com.dtcc.intern.dtcc.model;

import java.time.LocalDateTime;

public class User {
    private long userId;
    private String username;
    private String email;
    private String password;
    private LocalDateTime registrationDate;

    // Constructors, Getters, and Setters

    public User(long userId, String username, String email, String password, LocalDateTime registrationDate) {
        this.userId = userId;
        this.username = username;
        this.email = email;
        this.password = password;
        this.registrationDate = registrationDate;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDateTime getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDateTime registrationDate) {
        this.registrationDate = registrationDate;
    }
}
