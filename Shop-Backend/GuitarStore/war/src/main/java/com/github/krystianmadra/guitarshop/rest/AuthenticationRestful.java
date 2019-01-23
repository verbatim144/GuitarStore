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
            authenticate(user.getUsername(), user.getPassword());

            UserEntity dbUser = userDao.getUserWithCredentials(user.getUsername(),user.getPassword()).get();

            Token token = issueToken(dbUser.getId(), dbUser.getRole());
            loginManager.saveNewToken(token);

            return Response.ok(token).build();
        } catch (Exception exc){
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }
    }

    private void authenticate(String username, String password) throws Exception{
        UserDTO ret = new UserDTO(userDao.getUserWithCredentials(username,password).get());
        if(ret.getId() == null){
            throw new IllegalArgumentException("There is no user with these credentials");
        }
    }

    private Token issueToken(Long userId, Role userRole) {
        Token token = new Token(userId, userRole);
        userDao.updateToken(userId, token.getToken(), token.getExpirationDate());

        return token;
    }

}
