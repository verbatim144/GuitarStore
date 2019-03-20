package com.github.krystianmadra.guitarshop.guitar;

import com.github.krystianmadra.guitarshop.entities.GuitarEntity;

import java.math.BigDecimal;

public class GuitarDTO {

    private Long id;
    private String name;
    private double price;
    private String description;
    private long quantity;
    private String imgUrl;
    private String category;

    public GuitarDTO() {
    }

    public GuitarDTO(GuitarEntity entity) {
        id = entity.getId();
        name = entity.getName();
        price = entity.getPrice();
        quantity = entity.getQuantity();
        description = entity.getDescription();
        category = entity.getCategory().getName();
        imgUrl = entity.getImgUrl();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
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