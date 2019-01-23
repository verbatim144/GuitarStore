package com.github.krystianmadra.guitarshop.rest;

import com.github.krystianmadra.guitarshop.GuitarDao;
import com.github.krystianmadra.guitarshop.UserDao;
import com.github.krystianmadra.guitarshop.auth.Secured;
import com.github.krystianmadra.guitarshop.entities.GuitarEntity;
import com.github.krystianmadra.guitarshop.entities.ShoppingCartEntity;

import javax.ejb.EJB;
import javax.faces.bean.RequestScoped;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.Set;

@Path("/")
@RequestScoped
public class ShoppingCartRestful {

    @EJB
    private UserDao userDao;

    @EJB
    private GuitarDao guitarDao;

    @GET
    @Path("/shoppingCart/{id}")
    @Produces("application/json; charset=UTF-8")
    public Response getShoppingCartByUserId(@PathParam("id") Long id) {
        ShoppingCartEntity ret = new ShoppingCartEntity(userDao.getShoppingCartByUserId(id).get());
        return Response.status(200).entity(ret).build();
    }

    @POST
    @Consumes("application/json; charset=UTF-8")
    @Produces("application/json; charset=UTF-8")
    public Response addToShoppingCart(Long userId, Long guitarId){
        ShoppingCartEntity ret = userDao.getShoppingCartByUserId(userId).get();
        Set<GuitarEntity> productList = ret.getProducts();

        productList.add(guitarDao.getGuitarById(guitarId).get());
        ret.setProducts(productList);

        userDao.UpdateProductsList(ret);
        return Response.status(201).entity(ret).build();
    }

    /*
    @POST
    @Consumes("application/json; charset=UTF-8")
    @Produces("application/json; charset=UTF-8")
    public Response addNewOrder(OrderDTO orderDTO) {
        orderDao.addOrder(OrderDTOToEntity.toEntity(orderDTO));
        String ret = "Dokonano zamowienia";
        return Response.status(201).entity(ret).build();
    }
    */

}
