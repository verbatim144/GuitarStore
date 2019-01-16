package com.github.krystianmadra.guitarshop.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "GUITAR_CATEGORY")
public class GuitarCategoryEntity extends AbstractBaseEntity {

    private String name;
    @OneToMany(mappedBy = "guitarCategory")
    private Set<GuitarEntity> guitarSet;

    public GuitarCategoryEntity() {
    }

    public GuitarCategoryEntity(Long id, String categoryName) {
        super(id);
        this.name = categoryName;
    }

    public void setGuitarSet(Set<GuitarEntity> guitarList) {
        this.guitarSet = guitarList;
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

    public Set<GuitarEntity> getGuitarSet() {
        return guitarSet;
    }

}