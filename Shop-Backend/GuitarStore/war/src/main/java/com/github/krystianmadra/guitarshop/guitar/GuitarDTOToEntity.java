package com.github.krystianmadra.guitarshop.guitar;

import com.github.krystianmadra.guitarshop.entities.GuitarCategoryEntity;
import com.github.krystianmadra.guitarshop.entities.GuitarEntity;

public class GuitarDTOToEntity {

    public static GuitarEntity toEntity(GuitarDTO entity){
        GuitarEntity ret = new GuitarEntity(entity.getId());
        ret.setName(entity.getName());
        ret.setPrice(entity.getPrice());
        ret.setQuantity(entity.getQuantity());
        ret.setDescription(entity.getDescription());
        ret.setCategory(new GuitarCategoryEntity(entity.getCategory()));
        return ret;
    }
}
