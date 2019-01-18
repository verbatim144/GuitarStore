package com.github.krystianmadra.guitarshop.guitar;

import com.github.krystianmadra.guitarshop.entities.GuitarEntity;

import java.math.BigDecimal;

public class GuitarShortDTO {

    private Long id;
    private String name;
    private double price;
    private String description;

    public GuitarShortDTO(Long id, String name, double price, String description){
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public GuitarShortDTO(GuitarDTO guitarDTO){
        this.id = guitarDTO.getId();
        this.name = guitarDTO.getName();
        this.price = guitarDTO.getPrice();
        this.description = guitarDTO.getDescription();
    }

    public GuitarShortDTO(GuitarEntity entity) {
        id = entity.getId();
        name = entity.getName();
        price = entity.getPrice();
        description = entity.getDescription();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "GuitarShortDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
