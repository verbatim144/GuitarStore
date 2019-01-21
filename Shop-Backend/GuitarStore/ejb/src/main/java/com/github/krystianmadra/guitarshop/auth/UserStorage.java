package com.github.krystianmadra.guitarshop.auth;

import com.github.krystianmadra.guitarshop.entities.UserEntity;

import javax.ejb.Singleton;
import javax.ejb.Startup;
import java.util.HashSet;
import java.util.Set;

@Startup
@Singleton
public class UserStorage {


    private final Set<UserEntity> storage;

    public UserStorage() {
        storage = new HashSet<>();
        storage.add(new UserEntity(45L,"Baska","bas123","BassQwe@Lorem.ipsum"));
        storage.add(new UserEntity(46L,"Ania","ania123","AnkA1912@Lorem.ipsum"));
        storage.add(new UserEntity(47L,"Zoska","Zos123","ZosKaka@Lorem.ipsum"));
    }

    public Long tryToLogin(String username, String password) {
        return storage.stream().filter(user -> user.getUsername().equals(username) && user.getPassword().equals(password)).findFirst().get().getId();
    }
}
