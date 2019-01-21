package com.github.krystianmadra.guitarshop.rest;

import com.github.krystianmadra.guitarshop.UserDao;
import com.github.krystianmadra.guitarshop.auth.UserStorage;
import com.github.krystianmadra.guitarshop.entities.UserEntity;
import com.github.krystianmadra.guitarshop.user.UserDTO;
import com.github.krystianmadra.guitarshop.user.UserDTOToEntity;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/register")
public class Registration {

    @EJB
    private UserStorage userStorage;

    @EJB
    private UserDao userDao;

    @POST
    @Consumes("application/json")
    public Response registerUser(UserDTO validatedUser) {
        if(!userStorage.checkIfValidRegistrationForm(validatedUser.getEmail())){
            return Response.status(401).build();
        }
        UserEntity user = UserDTOToEntity.toEntity(validatedUser);

        userDao.saveUserID(user); // przydzial id
        UserEntity userToStorage = userDao.getUserById(user.getId()).get();

        userStorage.addUserCredentials(userToStorage);

        return Response.status(201).build();
    }

}
