package com.github.krystianmadra.guitarshop.controller;

import com.github.krystianmadra.guitarshop.model.GuitarDTO;
import com.github.krystianmadra.guitarshop.model.GuitarShortDTO;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Path("/guitar")
public class GuitarRestful {

    private final Set<GuitarDTO> database = new HashSet<>();

    public GuitarRestful() {
        mockDatabase();
    }

    private void mockDatabase() {
        database.add(new GuitarDTO(1l, "Ibanez 740", 1199.99));
        database.add(new GuitarDTO(2l, "Yamaha C30M", 530.0));
        database.add(new GuitarDTO(1l, "Yamaha F310P", 730.99));
    }

    @GET
    @Path("/{id}")
    @Produces("application/json; charset=UTF-8")
    public Response getById(@PathParam("id") long aId) {
        GuitarDTO ret = database.stream().filter(book -> book.getId() == aId).findFirst().get();
        return Response.status(200).entity(ret).build();
    }

    @GET
    @Produces("application/json; charset=UTF-8")
    public Response getAll() {
        List<GuitarShortDTO> ret = database.stream().map(GuitarShortDTO::new).collect(Collectors.toList());
        return Response.status(200).entity(ret).build();
    }
}
