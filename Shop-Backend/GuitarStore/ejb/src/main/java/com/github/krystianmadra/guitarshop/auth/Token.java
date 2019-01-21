package com.github.krystianmadra.guitarshop.auth;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.time.Instant;
import java.time.LocalTime;
import java.util.Date;
import java.util.Random;

public class Token {

    private final static SecureRandom random = new SecureRandom();
    private String token;
    private LocalTime expirationDate;
    private Long userId;

    public Token(Long userId) {
        this(userId, new BigInteger(130, random).toString(32));
        this.userId = userId;
        this.expirationDate = LocalTime.now().plusMinutes(10).plusHours(1);
    }

    public Token(Long userId, String token) {
        this.token = token;
        this.userId = userId;
        this.expirationDate = LocalTime.now().plusMinutes(10);
    }

    public String getToken() {
        return token;
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
}
