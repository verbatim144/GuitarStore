package com.github.krystianmadra.guitarshop.entities;

import javax.persistence.*;
import java.time.Instant;
import java.util.Date;
import java.util.List;

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

    @ManyToOne
    private UserEntity user;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "order")
    private List<OrderDetails> ordersDetails;

    public OrderEntity() {
    }

    public OrderEntity(OrderState state, List<OrderDetails> ordersDetails, UserEntity user) {
        this.orderDate = Date.from(Instant.now());
        this.state = state;
        this.ordersDetails = ordersDetails;
        this.user = user;
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

    public List<OrderDetails> getOrdersDetails() {
        return ordersDetails;
    }

    public void setOrdersDetails(List<OrderDetails> ordersDetails) {
        this.ordersDetails = ordersDetails;
    }
}
