package com.github.krystianmadra.guitarshop.entities;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "OPINION")
public class OpinionEntity extends AbstractBaseEntity {

    private String shortComment;
    private int rate;

    public OpinionEntity() {
    }

    public OpinionEntity(Long id) {
        super(id);
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
