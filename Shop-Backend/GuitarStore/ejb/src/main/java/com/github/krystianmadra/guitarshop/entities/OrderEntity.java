package com.github.krystianmadra.guitarshop.entities;

import javax.persistence.*;
import java.time.Instant;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "ORDERS")
public class OrderEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;
    private LocalTime orderDate;

    @Enumerated
    private OrderState state;

    @ManyToOne
    private UserEntity user;

    @OneToMany
    List<GuitarEntity> guitars;

    //@OneToMany(cascade = CascadeType.ALL, mappedBy = "order")
    //private List<OrderDetails> ordersDetails;

    public OrderEntity() {
    }

    public OrderEntity(UserEntity user) {
        this.orderDate = LocalTime.now();
        this.state = OrderState.PROCESSING;
        this.user = user;
    }

    public OrderEntity(UserEntity user, List<GuitarEntity> guitars) {
        this.orderDate = LocalTime.now();
        this.state = OrderState.PROCESSING;
        //this.ordersDetails = ordersDetails;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<GuitarEntity> getGuitars() {
        return guitars;
    }

    public void setGuitars(List<GuitarEntity> guitars) {
        this.guitars = guitars;
    }

    public LocalTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalTime orderDate) {
        this.orderDate = orderDate;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public OrderState getState() {
        return state;
    }

    public void setState(OrderState state) {
        this.state = state;
    }

    /*
    public List<OrderDetails> getOrdersDetails() {
        return ordersDetails;
    }

    public void setOrdersDetails(List<OrderDetails> ordersDetails) {
        this.ordersDetails = ordersDetails;
    }
    */
}
