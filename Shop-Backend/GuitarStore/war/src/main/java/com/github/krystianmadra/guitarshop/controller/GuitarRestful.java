package com.github.krystianmadra.guitarshop.controller;

import com.github.krystianmadra.guitarshop.GuitarDao;
import com.github.krystianmadra.guitarshop.entities.GuitarEntity;
import com.github.krystianmadra.guitarshop.guitar.GuitarDTO;
import com.github.krystianmadra.guitarshop.guitar.GuitarDTOToEntity;
import com.github.krystianmadra.guitarshop.guitar.GuitarShortDTO;

import javax.ejb.EJB;
import javax.faces.bean.RequestScoped;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.stream.Collectors;

@Path("/guitar")
@RequestScoped // przez scope provided - do DI
public class GuitarRestful {

    @EJB
    private GuitarDao guitarDao;

    @GET
    @Path("/{id}")
    @Produces("application/json; charset=UTF-8")
    public Response getById(@PathParam("id") long id) {
        GuitarDTO ret = new GuitarDTO(guitarDao.getGuitarById(id).get());
        return Response.status(200).entity(ret).build();
    }

    @GET
    @Path("/name/{name}")
    @Produces("application/json; charset=UTF-8")
    public Response getById(@PathParam("name") String name) {
        GuitarDTO ret = new GuitarDTO(guitarDao.getGuitarByName(name).get());
        return Response.status(200).entity(ret).build();
    }

    @GET
    @Produces("application/json; charset=UTF-8")
    public Response getAll() {
        List<GuitarShortDTO> ret = guitarDao.getAll().stream().map(GuitarShortDTO::new).collect(Collectors.toList());
        return Response.status(200).entity(ret).build();
    }

    @POST
    @Consumes("application/json; charset=UTF-8")
    @Produces("application/json; charset=UTF-8")
    public Response addGuitar(GuitarDTO guitar) {
        GuitarEntity entity = guitarDao.addGuitar(GuitarDTOToEntity.toEntity(guitar));
        GuitarDTO ret = new GuitarDTO(entity);
        return Response.status(201).entity(ret).build();
    }

    @DELETE
    @Path("{id}")
    @Consumes("application/json; charset=UTF-8")
    @Produces("application/json; charset=UTF-8")
    public Response removeGuitar(@PathParam("id") long id) {
        guitarDao.remove(id);
        return Response.status(204).build();
    }

    @PUT
    @Consumes("application/json; charset=UTF-8")
    @Produces("application/json; charset=UTF-8")
    public Response editGuitar(GuitarDTO guitar) {
        guitarDao.update(GuitarDTOToEntity.toEntity(guitar));
        return Response.status(200).entity(guitar).build();
    }
}
