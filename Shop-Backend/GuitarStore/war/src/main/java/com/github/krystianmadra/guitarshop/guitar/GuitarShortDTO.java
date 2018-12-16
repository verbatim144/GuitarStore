package com.github.krystianmadra.guitarshop.guitar;

import com.github.krystianmadra.guitarshop.entities.GuitarEntity;

public class GuitarShortDTO {

    private Long id;
    private String name;
    private double price;

    public GuitarShortDTO(Long id, String name, double price){
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public GuitarShortDTO(GuitarDTO guitarDTO){
        this.id = guitarDTO.getId();
        this.name = guitarDTO.getName();
        this.price = guitarDTO.getPrice();
    }

    public GuitarShortDTO(GuitarEntity entity) {
        id = entity.getId();
        name = entity.getName();
        price = entity.getPrice();
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

    @Override
    public String toString() {
        return "GuitarShortDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
