package com.github.krystianmadra.guitarshop.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "GUITAR_CATEGORY")
public class GuitarCategoryEntity extends AbstractBaseEntity {

    private String name;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "category")
    private Set<GuitarEntity> guitars;

    public GuitarCategoryEntity() {
    }

    public GuitarCategoryEntity(Long id, String categoryName) {
        super(id);
        this.name = categoryName;
    }

    public GuitarCategoryEntity(String categoryName) {
        this.name = categoryName;
    }

    public void setGuitars(Set<GuitarEntity> guitars) {
        this.guitars = guitars;
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

    public Set<GuitarEntity> getGuitars() {
        return guitars;
    }
}