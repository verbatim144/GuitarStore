package com.github.krystianmadra.guitarshop.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "GUITAR_CATEGORY")
public class GuitarCategoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;
    private String name;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "category")
    private Set<GuitarEntity> guitars;

    public GuitarCategoryEntity() {
    }

    public GuitarCategoryEntity(Long id, String categoryName) {
        this.id = id;
        this.name = categoryName;
    }

    public GuitarCategoryEntity(Long id) {
        this.id = id;
    }

    public GuitarCategoryEntity(String categoryName) {
        this.name = categoryName;
    }

    public void setGuitars(Set<GuitarEntity> guitars) {
        this.guitars = guitars;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<GuitarEntity> getGuitars() {
        return guitars;
    }
}