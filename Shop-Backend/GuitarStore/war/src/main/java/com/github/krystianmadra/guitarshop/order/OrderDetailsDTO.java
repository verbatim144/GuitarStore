package com.github.krystianmadra.guitarshop.order;

import com.github.krystianmadra.guitarshop.RandomOrderCode;
import com.github.krystianmadra.guitarshop.entities.OrderDetails;
import com.github.krystianmadra.guitarshop.guitar.GuitarDTO;

public class OrderDetailsDTO {

    private Long id;
    private double sum;
    private String orderCode;
    private long quantityOrdered;
    private long guitar;

    public OrderDetailsDTO (){
        orderCode = RandomOrderCode.randomString(5);
    }

    public OrderDetailsDTO (OrderDetails orderDetailsEntity){
        id = orderDetailsEntity.getId();
        sum = orderDetailsEntity.getSum();
        orderCode = orderDetailsEntity.getOrderCode();
        quantityOrdered = orderDetailsEntity.getQuantityOrdered();
        guitar = orderDetailsEntity.getGuitar().getId();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
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

    public long getGuitar() {
        return guitar;
    }

    public void setGuitar(long guitar) {
        this.guitar = guitar;
    }
}
