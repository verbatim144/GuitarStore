package com.github.krystianmadra.guitarshop.entities;

import javax.persistence.*;

@Entity
@Table(name = "ORDER_DETAILS")
public class OrderDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;
    @ManyToOne(cascade = CascadeType.ALL)
    private OrderEntity order;
    @ManyToOne(cascade = CascadeType.ALL)
    private GuitarEntity guitarEntity;
    private int orderNumber;
    private double price;

}
