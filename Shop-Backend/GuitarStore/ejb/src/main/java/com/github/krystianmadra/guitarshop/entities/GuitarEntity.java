package com.github.krystianmadra.guitarshop.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "GUITAR")
public class GuitarEntity extends AbstractBaseEntity {

    private String name;
    private BigDecimal price;
    @ManyToOne(cascade = CascadeType.ALL)
    private ManufacturerEntity manufacturer;
    @ManyToOne(cascade = CascadeType.ALL)
    private GuitarCategoryEntity guitarCategory;
    @ManyToOne(cascade = CascadeType.ALL)
    private List<OpinionEntity> opinionEntity;

    public GuitarEntity(String name, BigDecimal price){
        this.name = name;
        this.price = price;
        opinionEntity = new ArrayList<>();
    }

    public GuitarEntity(){
        opinionEntity = new ArrayList<>();
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

    public ManufacturerEntity getManufacturer() {
        return manufacturer;
    }

    public GuitarCategoryEntity getGuitarCategory() {
        return guitarCategory;
    }

    public void update(GuitarEntity guitarEntity) {
        this.name = guitarEntity.name;
        this.price = guitarEntity.price;
    }
}
