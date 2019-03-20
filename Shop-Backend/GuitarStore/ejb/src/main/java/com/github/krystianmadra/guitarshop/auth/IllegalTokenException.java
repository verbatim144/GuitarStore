package com.github.krystianmadra.guitarshop.auth;

public class IllegalTokenException extends RuntimeException  {
    private String message;

    public IllegalTokenException(String s) {
        this.message = s;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
