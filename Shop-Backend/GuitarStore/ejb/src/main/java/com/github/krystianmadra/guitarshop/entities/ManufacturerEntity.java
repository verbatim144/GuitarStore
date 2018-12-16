package com.github.krystianmadra.guitarshop.entities;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "MANUFACTURER")
public class ManufacturerEntity extends AbstractBaseEntity {

    private String name;

    public ManufacturerEntity() {
    }

    public ManufacturerEntity(Long id) {
        super(id);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
