package com.github.krystianmadra.guitarshop.rest;

import com.github.krystianmadra.guitarshop.GuitarDao;
import com.github.krystianmadra.guitarshop.entities.GuitarEntity;
import com.github.krystianmadra.guitarshop.guitar.GuitarDTO;
import com.github.krystianmadra.guitarshop.guitar.GuitarDTOToEntity;
import com.github.krystianmadra.guitarshop.guitar.GuitarShortDTO;
import com.github.krystianmadra.guitarshop.auth.Secured;

import javax.ejb.EJB;
import javax.faces.bean.RequestScoped;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Path("/guitar")
@RequestScoped // przez scope provided - do DI
public class GuitarRestful {

    @EJB
    private GuitarDao guitarDao;

    @GET
    @Secured
    @Path("/{id}")
    @Produces("application/json; charset=UTF-8")
    public Response getById(@PathParam("id") long id) {
        if(!guitarDao.findById(id).isPresent()){
            return Response.status(404).entity("Nie znaleziono produktu o podanym id").build();
        }
        GuitarDTO ret = new GuitarDTO(guitarDao.findById(id).get());
        return Response.status(200).entity(ret).build();

    }

    @GET
    @Path("/name/{name}")
    @Produces("application/json; charset=UTF-8")
    public Response getByName(@PathParam("name") String name) {
        if(!guitarDao.findByName(name).isPresent()){
            return Response.status(404).entity("Nie znaleziono produktu o nazwie: " + name).build();
        }
        GuitarDTO ret = new GuitarDTO(guitarDao.findByName(name).get());
        return Response.status(200).entity(ret).build();
    }

    @GET
    @Produces("application/json; charset=UTF-8")
    public Response getAll() {
        List<GuitarShortDTO> ret = guitarDao.findAll().stream().map(GuitarShortDTO::new).collect(Collectors.toList());
        return Response.status(200).entity(ret).build();
    }

    @POST
    @Secured
    @Consumes("application/json; charset=UTF-8")
    @Produces("application/json; charset=UTF-8")
    public Response addGuitar(GuitarDTO guitar) {
        Optional<GuitarEntity> entity = guitarDao.add(GuitarDTOToEntity.toEntity(guitar));
        if(!entity.isPresent()){
            return Response.status(403).entity("Object already exists!").build();
        }
        GuitarDTO ret = new GuitarDTO(entity.get());
        return Response.status(201).entity(ret).build();
    }

    @DELETE
    @Secured
    @Path("{id}")
    @Consumes("application/json; charset=UTF-8")
    @Produces("application/json; charset=UTF-8")
    public Response removeGuitar(@PathParam("id") long id) {
        guitarDao.remove(id);
        return Response.status(204).build();
    }

    @PUT
    @Secured
    @Consumes("application/json; charset=UTF-8")
    @Produces("application/json; charset=UTF-8")
    public Response editGuitar(GuitarDTO guitar) {
        Optional<GuitarEntity> entity = guitarDao.update(GuitarDTOToEntity.toEntity(guitar));
        if(!entity.isPresent()){
            return Response.status(404).entity("Nie znaleziono produktu o podanym id <edit>").build();
        }
        return Response.status(200).entity(guitar).build();
    }
}
