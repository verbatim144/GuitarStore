package com.github.krystianmadra.guitarshop.guitar;

import com.github.krystianmadra.guitarshop.entities.GuitarEntity;

import java.math.BigDecimal;

public class GuitarDTO {

    private Long id;
    private String name;
    private BigDecimal price;

    public GuitarDTO(Long id, String name, BigDecimal price){
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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
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
