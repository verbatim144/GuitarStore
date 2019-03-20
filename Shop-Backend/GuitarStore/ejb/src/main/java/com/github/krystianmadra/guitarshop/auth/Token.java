package com.github.krystianmadra.guitarshop.auth;

import com.github.krystianmadra.guitarshop.entities.Role;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.time.LocalTime;

public class Token {

    private final static SecureRandom random = new SecureRandom();
    private String token;
    private LocalTime expirationDate;
    private String username;
    private Long userId;
    private Role userRole;

    public Token(Role role, String username) {
        this.userRole = role;
        this.username = username;
        this.token = new BigInteger(130, random).toString(32);
        this.expirationDate = LocalTime.now().plusHours(1).plusMinutes(10);
    }

    public String getToken() {
        return token;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public LocalTime getExpirationDate() {
        return expirationDate;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setExpirationDate(LocalTime expirationDate) {
        this.expirationDate = expirationDate;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public static SecureRandom getRandom() {
        return random;
    }

    public Role getUserRole() {
        return userRole;
    }

    public void setUserRole(Role userRole) {
        this.userRole = userRole;
    }
}
