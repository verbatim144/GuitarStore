package com.github.krystianmadra.guitarshop.model;

public class GuitarShortDTO extends Product {

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

    @Override
    public String toString() {
        return "GuitarShortDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
