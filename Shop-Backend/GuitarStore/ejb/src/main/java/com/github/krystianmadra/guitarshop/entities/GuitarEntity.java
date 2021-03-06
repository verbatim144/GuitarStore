package com.github.krystianmadra.guitarshop.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "GUITAR")
public class GuitarEntity extends AbstractBaseEntity {

    private String name;
    private double price;
    private long quantity;
    private String description;
    private String imgUrl;

    @ManyToOne
    private GuitarCategoryEntity category;

    public GuitarEntity(){
        this.category = new GuitarCategoryEntity();
    }

    public GuitarEntity(Long id){
        super(id);
        this.category = new GuitarCategoryEntity();
    }

    public GuitarEntity(String name, double price, long quantity, String description, GuitarCategoryEntity category, String imgUrl){
        this.name = name;
        this.price = price;
        this.imgUrl = imgUrl;
        this.quantity = quantity;
        this.description = description;
        this.category = category;
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

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public GuitarCategoryEntity getCategory() {
        return category;
    }

    public void setCategory(GuitarCategoryEntity category) {
        this.category = category;
    }

    public void update(GuitarEntity guitarEntity) {
        this.name = guitarEntity.getName();
        this.price = guitarEntity.getPrice();
        this.description = guitarEntity.getDescription();
        this.quantity = guitarEntity.getQuantity();
        this.imgUrl = guitarEntity.getImgUrl();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null){
            return false;
        }
        if (!(obj instanceof GuitarEntity)) {
            return false;
        }
        return this.getName().equals(((GuitarEntity) obj).getName());
    }
}
