package com.github.krystianmadra.guitarshop.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "GUITAR_CATEGORY")
public class GuitarCategoryEntity extends AbstractBaseEntity {

    private String name;
    @OneToMany(cascade = CascadeType.ALL)
    private List<GuitarEntity> guitarList;

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

    public List<GuitarEntity> getGuitarList() {
        return guitarList;
    }

}
