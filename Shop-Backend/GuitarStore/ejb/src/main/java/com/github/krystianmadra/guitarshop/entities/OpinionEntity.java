package com.github.krystianmadra.guitarshop.entities;

import javax.persistence.*;

@Entity
@Table(name = "OPINION")
public class OpinionEntity extends AbstractBaseEntity {

    private String shortComment;
    private int rate;

    @ManyToOne(cascade = CascadeType.ALL)
    private GuitarEntity guitar;

    public OpinionEntity(Long id, int rate, String shortComment) {
        super(id);
        this.rate = rate;
        this.shortComment = shortComment;
    }

    public OpinionEntity(Long id) {
        super(id);
    }

    public GuitarEntity getGuitarEntity() {
        return guitar;
    }

    public void setGuitarEntity(GuitarEntity guitarEntity) {
        this.guitar = guitarEntity;
    }

    public String getShortComment() {
        return shortComment;
    }

    public void setShortComment(String shortComment) {
        this.shortComment = shortComment;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }
}
