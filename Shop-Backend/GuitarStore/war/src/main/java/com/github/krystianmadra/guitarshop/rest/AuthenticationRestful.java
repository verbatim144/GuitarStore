package com.github.krystianmadra.guitarshop.rest;

import com.github.krystianmadra.guitarshop.UserDao;
import com.github.krystianmadra.guitarshop.auth.LoginManager;
import com.github.krystianmadra.guitarshop.auth.Token;
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
    @Consumes("application/json")
    public Response authenticateUser(UserEntity user){

        try{
            Token token = loginManager.tryToLogin(user.getUsername(), user.getPassword());

            issueToken(token);

            return Response.ok(token.getToken()).build();
        } catch (Exception exc){
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }
    }

    private void issueToken(Token token) {
        userDao.updateToken(token.getUserId(), token.getToken(), token.getExpirationDate());
    }

}
