package com.github.krystianmadra.guitarshop.guitar;

import com.github.krystianmadra.guitarshop.entities.GuitarEntity;

import java.math.BigDecimal;

public class GuitarShortDTO {

    private String name;
    private double price;
    private String description;
    private String category;
    private String imgUrl;

    public GuitarShortDTO(GuitarDTO guitarDTO){
        this.name = guitarDTO.getName();
        this.price = guitarDTO.getPrice();
        this.description = guitarDTO.getDescription();
        this.category = guitarDTO.getCategory();
        this.imgUrl = guitarDTO.getImgUrl();
    }

    public GuitarShortDTO(GuitarEntity entity) {
        name = entity.getName();
        price = entity.getPrice();
        description = entity.getDescription();
        category = entity.getCategory().getName();
        imgUrl = entity.getImgUrl();
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

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "GuitarShortDTO{" +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
