package com.github.krystianmadra.guitarshop.rest;

import com.github.krystianmadra.guitarshop.OrderDao;
import com.github.krystianmadra.guitarshop.UserDao;

import javax.ejb.EJB;
import javax.faces.bean.RequestScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("/stats")
@RequestScoped
public class StatisticsRestful {

    @EJB
    protected UserDao userDao;

    @EJB
    protected OrderDao orderDao;


    @GET
    @Path("/users")
    @Produces("application/json; charset=UTF-8")
    public Response getUsersAmount() {
        long amount = userDao.getAllUsers().size();
        return Response.status(200).entity(amount).build();
    }

    @GET
    @Path("/orders")
    @Produces("application/json; charset=UTF-8")
    public Response getOrdersAmount() {
        long amount = orderDao.getAllOrders().size();
        return Response.status(200).entity(amount).build();
    }

}
