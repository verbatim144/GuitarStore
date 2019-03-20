package com.github.krystianmadra.guitarshop.order;

import com.github.krystianmadra.guitarshop.RandomOrderCode;
import com.github.krystianmadra.guitarshop.entities.OrderEntity;
import com.github.krystianmadra.guitarshop.entities.OrderState;
import com.github.krystianmadra.guitarshop.guitar.GuitarDTO;

import java.time.LocalTime;
import java.util.*;
import java.util.stream.Collectors;

public class OrderDTO {

    private String user;
    private OrderState state;
    private LocalTime orderDate;
    private double totalPrice;
    private String orderCode;
    private Set<GuitarDTO> guitars;

    public OrderDTO() {
        state = OrderState.PROCESSING;
        orderCode = RandomOrderCode.randomString(5);
        orderDate = LocalTime.now();
    }

    public OrderDTO(OrderEntity orderEntity) {
        state = orderEntity.getState();
        user = orderEntity.getUser().getUsername();
        orderDate = orderEntity.getOrderDate();
        orderCode = orderEntity.getOrderCode();
        totalPrice = orderEntity.getTotalPrice();
        guitars = orderEntity.getGuitars().stream().map(GuitarDTO::new).collect(Collectors.toSet());
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }


    public LocalTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalTime orderDate) {
        this.orderDate = orderDate;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public OrderState getState() {
        return state;
    }

    public void setState(OrderState state) {
        this.state = state;
    }

    public Set<GuitarDTO> getGuitars() {
        return guitars;
    }

    public void setGuitars(Set<GuitarDTO> guitars) {
        this.guitars = guitars;
    }
}
