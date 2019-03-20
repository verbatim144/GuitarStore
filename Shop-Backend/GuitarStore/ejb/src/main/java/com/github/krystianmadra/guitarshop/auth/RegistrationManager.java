package com.github.krystianmadra.guitarshop.auth;

import com.github.krystianmadra.guitarshop.UserDao;
import com.github.krystianmadra.guitarshop.entities.UserEntity;

import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import java.util.Optional;
import java.util.regex.Pattern;

@Startup
@Singleton
public class RegistrationManager {

    public static final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    @EJB
    UserDao userDao;

    public void register(UserEntity userEntity){
        userDao.saveUser(userEntity);
    }

    public boolean registerIsValid(String username, String validatedEmail){
        Optional<UserEntity> user = userDao.getAllUsers().stream().filter(userEntity -> userEntity.getUsername().equals(username)).findFirst();
        if(user.isPresent() && !validatedEmail.matches(VALID_EMAIL_ADDRESS_REGEX.pattern())){
            return false;
        }
        return true;
    }
}
