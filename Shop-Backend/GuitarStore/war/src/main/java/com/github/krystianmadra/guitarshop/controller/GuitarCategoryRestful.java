package com.github.krystianmadra.guitarshop.controller;

import com.github.krystianmadra.guitarshop.GuitarCategoryDao;
import com.github.krystianmadra.guitarshop.guitar.GuitarCategoryDTO;
import com.github.krystianmadra.guitarshop.guitar.GuitarDTO;

import javax.ejb.EJB;
import javax.faces.bean.RequestScoped;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("/category")
@RequestScoped
public class GuitarCategoryRestful {

    @EJB
    private GuitarCategoryDao guitarCategoryDao;

    @GET
    @Path("/{name}")
    @Produces("application/json; charset=UTF-8")
    public Response getByName(@PathParam("name") String name) {
        GuitarCategoryDTO ret = new GuitarCategoryDTO(guitarCategoryDao.getGuitarCategoryByName(name).get());
        return Response.status(200).entity(ret).build();
    }

/*
    @GET
    @Path("/{id}")
    @Produces("application/json; charset=UTF-8")
    public Response getById(@PathParam("id") long id) {
        GuitarCategoryDTO ret = new GuitarCategoryDTO(guitarCategoryDao.getGuitarCategoryById(id).get());
        return Response.status(200).entity(ret).build();
    }
    */
}
