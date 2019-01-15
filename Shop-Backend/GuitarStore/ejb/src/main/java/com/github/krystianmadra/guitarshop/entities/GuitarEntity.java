package com.github.krystianmadra.guitarshop.entities;

import javax.persistence.*;
import java.math.BigDecimal;
@Entity
@Table(name = "GUITAR")
public class GuitarEntity extends AbstractBaseEntity {

    private String name;
    private BigDecimal price;
    @ManyToOne(cascade = CascadeType.ALL)
    private GuitarCategoryEntity guitarCategory;

    public GuitarEntity(String name, BigDecimal price){
        this.name = name;
        this.price = price;
    }

    public GuitarEntity(){
    }

    public GuitarEntity(long id){
        super(id);
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

    public GuitarCategoryEntity getGuitarCategory() {
        return guitarCategory;
    }

    public void update(GuitarEntity guitarEntity) {
        this.name = guitarEntity.name;
        this.price = guitarEntity.price;
    }
}
