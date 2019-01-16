package com.github.krystianmadra.guitarshop.guitar;

import com.github.krystianmadra.guitarshop.entities.GuitarCategoryEntity;
import com.github.krystianmadra.guitarshop.entities.GuitarEntity;

import java.util.Set;

public class GuitarCategoryDTO {

    private Long id;
    private String name;
    private Set<GuitarEntity> guitarSet;

    public GuitarCategoryDTO(Long id, String name, Set<GuitarEntity> guitarSet){
        this.id = id;
        this.name = name;
        this.guitarSet = guitarSet;
    }


    public GuitarCategoryDTO(GuitarCategoryEntity entity) {
        id = entity.getId();
        name = entity.getName();
        guitarSet = entity.getGuitarSet();
    }
    public void setGuitarSet(Set<GuitarEntity> guitarList) {
        this.guitarSet = guitarList;
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

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GuitarCategoryDTO guitarCategoryDTO = (GuitarCategoryDTO) o;

        return id != null ? id.equals(guitarCategoryDTO.id) : guitarCategoryDTO.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
