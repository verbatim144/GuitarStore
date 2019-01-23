package com.github.krystianmadra.guitarshop.guitar;

import com.github.krystianmadra.guitarshop.entities.GuitarEntity;

public class GuitarEntityToDTO {

    public static GuitarDTO toDto(GuitarEntity entity){
        GuitarDTO ret = new GuitarDTO();
        ret.setId(entity.getId());
        ret.setName(entity.getName());
        ret.setPrice(entity.getPrice());
        ret.setQuantity(entity.getQuantity());
        ret.setDescription(entity.getDescription());
        ret.setCategory(entity.getCategory().getName());
        return ret;
    }
}
