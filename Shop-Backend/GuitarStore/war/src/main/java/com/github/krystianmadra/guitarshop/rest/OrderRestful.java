package com.github.krystianmadra.guitarshop.rest;

import com.github.krystianmadra.guitarshop.OrderDao;
import com.github.krystianmadra.guitarshop.auth.Secured;
import com.github.krystianmadra.guitarshop.entities.Role;
import com.github.krystianmadra.guitarshop.order.OrderDTO;
import com.github.krystianmadra.guitarshop.order.OrderDTOToEntity;

import javax.ejb.EJB;
import javax.faces.bean.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;


@Path("/order")
@RequestScoped
public class OrderRestful {

    @EJB
    private OrderDao orderDao;

    @POST
    //@Secured({Role.USER})
    @Consumes("application/json; charset=UTF-8")
    @Produces("application/json; charset=UTF-8")
    public Response add(OrderDTO order) {
        orderDao.add(OrderDTOToEntity.toEntity(order));

        return Response.status(201).entity("Dokonano zamowienia").build();
    }

}
