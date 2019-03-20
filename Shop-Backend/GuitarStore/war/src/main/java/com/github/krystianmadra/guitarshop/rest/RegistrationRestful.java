package com.github.krystianmadra.guitarshop.rest;

import com.github.krystianmadra.guitarshop.auth.RegistrationManager;
import com.github.krystianmadra.guitarshop.user.UserDTO;
import com.github.krystianmadra.guitarshop.user.UserDTOToEntity;

import javax.ejb.EJB;
import javax.faces.bean.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("/register")
@RequestScoped
public class RegistrationRestful {

    @EJB
    private RegistrationManager registrationManager;

    @POST
    @Consumes("application/json; charset=UTF-8")
    @Produces("application/json; charset=UTF-8")
    public Response register(UserDTO user) {
        if(registrationManager.registerIsValid(user.getUsername(), user.getEmail())) {
            registrationManager.register(UserDTOToEntity.toEntity(user));
            return Response.status(201).build();
        }
        return Response.status(401).build();
    }

}
