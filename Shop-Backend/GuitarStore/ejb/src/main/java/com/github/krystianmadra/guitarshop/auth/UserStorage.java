package com.github.krystianmadra.guitarshop.auth;

import com.github.krystianmadra.guitarshop.entities.UserEntity;

import javax.ejb.Singleton;
import javax.ejb.Startup;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.regex.Pattern;

@Startup
@Singleton
public class UserStorage {

    public static final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);


    private final Set<UserEntity> storage;

    public UserStorage() {
        storage = new HashSet<>();
        storage.add(new UserEntity(45L,"Baska","bas123","BassQwe@Lorem.ipsum"));
        storage.add(new UserEntity(46L,"Ania","ania123","AnkA1912@Lorem.ipsum"));
        storage.add(new UserEntity(47L,"Zoska","Zos123","ZosKaka@Lorem.ipsum"));
    }

    public void addUserCredentials(UserEntity user){
        storage.add(user);
    }

    public boolean checkIfValidRegistrationForm(String validatedEmail){
        /*
        Optional<UserEntity> storagedUser = storage.stream().filter(u -> u.getEmail().equals(validatedEmail)).findFirst();
        if(storagedUser.isPresent()){ //|| !validatedEmail.matches(VALID_EMAIL_ADDRESS_REGEX.pattern())){
            return false;
        }
        */
        return true;
    }

    public UserEntity getUserWithCredentials(String username, String password){
        return storage.stream().filter(user -> user.getUsername().equals(username) && user.getPassword().equals(password)).findFirst().get();
    }


    public Long tryToLogin(String username, String password) {
        return storage.stream().filter(user -> user.getUsername().equals(username) && user.getPassword().equals(password)).findFirst().get().getId();
    }
}
