package com.github.krystianmadra.guitarshop.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "GUITAR_CATEGORY")
public class GuitarCategoryEntity extends AbstractBaseEntity {

    private String name;
    @OneToMany(cascade = CascadeType.ALL)
    private Set<GuitarEntity> guitarList;

    public GuitarCategoryEntity() {
    }

    public GuitarCategoryEntity(Long id) {
        super(id);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<GuitarEntity> getGuitarList() {
        return guitarList;
    }

}