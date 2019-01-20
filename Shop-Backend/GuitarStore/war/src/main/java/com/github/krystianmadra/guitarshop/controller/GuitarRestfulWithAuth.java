package com.github.krystianmadra.guitarshop.controller;

import com.github.krystianmadra.guitarshop.GuitarDao;
import com.github.krystianmadra.guitarshop.auth.LoginManager;
import com.github.krystianmadra.guitarshop.auth.UserStorage;
import com.github.krystianmadra.guitarshop.entities.UserEntity;
import com.github.krystianmadra.guitarshop.guitar.GuitarDTO;

import javax.ejb.EJB;
import javax.faces.bean.RequestScoped;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.time.LocalTime;

//@Path("/guitarAuth")
//@RequestScoped
public class GuitarRestfulWithAuth {

    /*

    @EJB
    private GuitarDao guitarDao;

    @EJB
    private LoginManager loginManager;

    @EJB
    private UserStorage userStorage;

    @GET
    @Path("/{id}")
    @Produces("application/json; charset=UTF-8")
    public Response getById(@HeaderParam("token") String aToken, @PathParam("id") long aId) {
        Long userId = loginManager.getUserIdFromToken(aToken);
        if (userId != null) {
            GuitarDTO ret = new GuitarDTO(guitarDao.getGuitarById(aId).get());
            return Response.status(200).entity(ret).build();
        }
        else
        {
            return Response.status(403).entity("You have to login!").build();
        }
    }

    @POST
    @Path("/login")
    @Produces("application/json; charset=UTF-8")
    public Response login(UserEntity user){
        return Response.status(200).entity(loginManager.tryToLogin(user.getUsername(), user.getPassword())).build();
    }

    */
}
