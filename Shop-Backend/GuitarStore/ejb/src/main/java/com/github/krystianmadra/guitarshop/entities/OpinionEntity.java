package com.github.krystianmadra.guitarshop.entities;

import javax.persistence.*;

@Entity
@Table(name = "OPINION")
public class OpinionEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;
    private int rate;
    private String shortComment;

    @ManyToOne
    private GuitarEntity guitar;

    @ManyToOne
    private UserEntity user;

    public OpinionEntity() {
    }

    public OpinionEntity(Long id, int rate, String shortComment) {
        this.id = id;
        this.rate = rate;
        this.shortComment = shortComment;
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
