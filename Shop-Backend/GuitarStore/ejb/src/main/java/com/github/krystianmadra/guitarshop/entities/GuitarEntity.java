package com.github.krystianmadra.guitarshop.entities;

import java.io.Serializable;

public class GuitarEntity implements Serializable {

    private Long id;
    private String name;
    private double price;

    public GuitarEntity(Long id, String name, double price){
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public GuitarEntity(){
    }

    public GuitarEntity(long id){
        this.id = id;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GuitarEntity guitarDto = (GuitarEntity) o;

        return id != null ? id.equals(guitarDto.id) : guitarDto.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    public void update(GuitarEntity guitarEntity) {
        this.id = guitarEntity.id;
        this.name = guitarEntity.name;
        this.price = guitarEntity.price;
    }
}
