package com.github.krystianmadra.guitarshop.order;

import com.github.krystianmadra.guitarshop.entities.OrderEntity;
import com.github.krystianmadra.guitarshop.entities.OrderState;
import com.github.krystianmadra.guitarshop.guitar.GuitarDTO;

import java.time.LocalTime;
import java.util.List;

public class OrderDTO {

    private Long id;
    private LocalTime orderDate;
    private Long user;
    private OrderState state;
    private List<GuitarDTO> guitars;
    //private List<OrderDetailsDTO> ordersDetails;

    public OrderDTO() {
        state = OrderState.PROCESSING;
    }

    public OrderDTO(OrderEntity orderEntity) {
        id = orderEntity.getId();
        orderDate = orderEntity.getOrderDate();
        state = orderEntity.getState();
        user = orderEntity.getUser().getId();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalTime orderDate) {
        this.orderDate = orderDate;
    }

    public Long getUser() {
        return user;
    }

    public void setUser(Long user) {
        this.user = user;
    }

    public List<GuitarDTO> getGuitars() {
        return guitars;
    }

    public void setGuitars(List<GuitarDTO> guitars) {
        this.guitars = guitars;
    }

    public OrderState getState() {
        return state;
    }

    public void setState(OrderState state) {
        this.state = state;
    }

    /*
    public List<OrderDetailsDTO> getOrdersDetails() {
        return ordersDetails;
    }

    public void setOrdersDetails(List<OrderDetailsDTO> ordersDetails) {
        this.ordersDetails = ordersDetails;
    }
    */
}
