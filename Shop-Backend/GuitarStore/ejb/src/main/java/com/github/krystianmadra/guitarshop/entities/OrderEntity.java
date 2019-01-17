package com.github.krystianmadra.guitarshop.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "ORDERS")
public class OrderEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;
    private Date orderDate;
    private String comments;
    @Enumerated
    private OrderState state;
    @OneToMany(mappedBy = "order")
    private Set<OrderDetails> ordersDetails;
    @ManyToOne(cascade = CascadeType.ALL)
    private UserEntity user;

    public OrderEntity(Date orderDate, String comments, OrderState state, Set<OrderDetails> ordersDetails, UserEntity user) {
        this.orderDate = orderDate;
        this.comments = comments;
        this.state = state;
        this.ordersDetails = ordersDetails;
        this.user = user;
    }

    public OrderEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public OrderState getState() {
        return state;
    }

    public void setState(OrderState state) {
        this.state = state;
    }

    public Set<OrderDetails> getOrdersDetails() {
        return ordersDetails;
    }

    public void setOrdersDetails(Set<OrderDetails> ordersDetails) {
        this.ordersDetails = ordersDetails;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }
}
