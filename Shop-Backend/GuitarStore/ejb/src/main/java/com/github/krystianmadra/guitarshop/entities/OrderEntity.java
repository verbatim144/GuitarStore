package com.github.krystianmadra.guitarshop.entities;

import com.github.krystianmadra.guitarshop.RandomOrderCode;

import javax.persistence.*;
import java.time.LocalTime;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "ORDERS")
public class OrderEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;
    private LocalTime orderDate;
    private double totalPrice;
    private String orderCode;

    @Enumerated
    private OrderState state;

    @ManyToOne
    private UserEntity user;

    @OneToMany
    private Set<GuitarEntity> guitars;

    public OrderEntity() {
        this.orderDate = LocalTime.now();
        this.state = OrderState.PENDING_PAYMENT;
        this.orderCode = RandomOrderCode.randomString(5);
    }

    public OrderEntity(UserEntity user) {
        this();
        this.user = user;
    }

    public OrderEntity(UserEntity user, Set<GuitarEntity> guitars) {
        this(user);
        this.guitars = guitars;
        this.totalPrice = initTotalPrice(guitars);
    }

    private double initTotalPrice(Set<GuitarEntity> guitars){
        double totalPrice = 0;
        for (GuitarEntity guitar : guitars){
            totalPrice += guitar.getPrice(); //* guitar.getQuantity(); * discount;
        }
        return totalPrice;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Long getId() {
        return id;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
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

    public Set<GuitarEntity> getGuitars() {
        return guitars;
    }

    public void setGuitars(Set<GuitarEntity> guitars) {
        this.guitars = guitars;
    }
}
