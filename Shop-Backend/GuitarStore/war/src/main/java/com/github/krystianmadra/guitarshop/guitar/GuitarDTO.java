package com.github.krystianmadra.guitarshop.guitar;

import com.github.krystianmadra.guitarshop.GuitarEntity;

public class GuitarDTO {

    private Long id;
    private String name;
    private double price;

    public GuitarDTO(Long id, String name, double price){
        this.id = id;
        this.name = name;
        this.price = price;
    }


    public GuitarDTO(GuitarEntity entity) {
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

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GuitarDTO guitarDTO = (GuitarDTO) o;

        return id != null ? id.equals(guitarDTO.id) : guitarDTO.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
