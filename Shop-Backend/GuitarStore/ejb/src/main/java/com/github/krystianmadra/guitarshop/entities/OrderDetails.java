package com.github.krystianmadra.guitarshop.entities;

import com.github.krystianmadra.guitarshop.RandomOrderCode;

import javax.persistence.*;

@Entity
@Table(name = "ORDER_DETAILS")
public class OrderDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;
    private double sum;
    private String orderCode;
    private long quantityOrdered;

    @ManyToOne
    private OrderEntity order;

    @OneToOne
    private GuitarEntity guitar;

    public OrderDetails() {
    }

    public OrderDetails(OrderEntity order, long quantityOrdered, GuitarEntity guitar) {
        this.order = order;
        this.guitar = guitar;
        this.orderCode = RandomOrderCode.randomString(5);
        this.quantityOrdered = quantityOrdered;
        this.sum = quantityOrdered * guitar.getPrice();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public OrderEntity getOrder() {
        return order;
    }

    public void setOrder(OrderEntity order) {
        this.order = order;
    }

    public GuitarEntity getGuitar() {
        return guitar;
    }

    public void setGuitar(GuitarEntity guitar) {
        this.guitar = guitar;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public long getQuantityOrdered() {
        return quantityOrdered;
    }

    public void setQuantityOrdered(long quantityOrdered) {
        this.quantityOrdered = quantityOrdered;
    }

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }
}
