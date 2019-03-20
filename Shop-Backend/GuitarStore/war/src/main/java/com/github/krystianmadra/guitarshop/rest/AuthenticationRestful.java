package com.github.krystianmadra.guitarshop.rest;

import com.github.krystianmadra.guitarshop.UserDao;
import com.github.krystianmadra.guitarshop.auth.LoginManager;
import com.github.krystianmadra.guitarshop.auth.Token;
import com.github.krystianmadra.guitarshop.entities.Role;
import com.github.krystianmadra.guitarshop.entities.UserEntity;
import com.github.krystianmadra.guitarshop.user.UserDTO;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("/login")
public class AuthenticationRestful {

    @EJB
    private UserDao userDao;

    @EJB
    private LoginManager loginManager;

    @POST
    @Produces("application/json")
    public Response authenticateUser(UserEntity user){

        try{
            UserEntity dbUser = userDao.getUserWithCredentials(user.getUsername(),user.getPassword()).get();

            Token token = issueTokenTo(dbUser);
            loginManager.saveNewToken(token);

            return Response.ok(token).build();
        } catch (Exception exc){
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }
    }

    private Token issueTokenTo(UserEntity user) {
        Token token = new Token(user.getRole(), user.getUsername());
        userDao.updateToken(user, token);

        return token;
    }

}
