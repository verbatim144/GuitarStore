package com.github.krystianmadra.guitarshop.user;

import com.github.krystianmadra.guitarshop.entities.UserEntity;

import java.time.LocalTime;

public class UserDTO {

    private Long id;
    private String username;
    private String password;
    private String email;
    private String token;
    private LocalTime tokenExpirationDate;

    public UserDTO() {
    }

    public UserDTO(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public UserDTO(UserEntity user) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.email = user.getEmail();
        this.token = user.getToken();
        this.tokenExpirationDate = user.getTokenExpirationDate();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public LocalTime getTokenExpirationDate() {
        return tokenExpirationDate;
    }

    public void setTokenExpirationDate(LocalTime tokenExpirationDate) {
        this.tokenExpirationDate = tokenExpirationDate;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
