package com.github.krystianmadra.guitarshop.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "GUITAR")
public class GuitarEntity extends AbstractBaseEntity {

    private String name;
    private BigDecimal price;
    private long amount;
    @ManyToOne(cascade = CascadeType.ALL)
    private GuitarCategoryEntity guitarCategory;

    @OneToMany(mappedBy = "guitar")
    private List<OpinionEntity> opinionEntities;

    public GuitarEntity(Long id, String name, BigDecimal price, GuitarCategoryEntity guitarCategory){
        super(id);
        this.name = name;
        this.price = price;
        this.guitarCategory = guitarCategory;
    }

    public GuitarEntity(){
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
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

    public void setGuitarCategory(GuitarCategoryEntity guitarCategory) {
        this.guitarCategory = guitarCategory;
    }

    public List<OpinionEntity> getOpinionEntities() {
        return opinionEntities;
    }

    public void setOpinionEntities(List<OpinionEntity> opinionEntities) {
        this.opinionEntities = opinionEntities;
    }

    public void update(GuitarEntity guitarEntity) {
        this.name = guitarEntity.name;
        this.price = guitarEntity.price;
    }
}
