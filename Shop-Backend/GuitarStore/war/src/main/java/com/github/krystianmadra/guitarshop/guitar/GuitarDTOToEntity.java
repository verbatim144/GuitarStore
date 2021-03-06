package com.github.krystianmadra.guitarshop.guitar;

import com.github.krystianmadra.guitarshop.entities.GuitarCategoryEntity;
import com.github.krystianmadra.guitarshop.entities.GuitarEntity;

public class GuitarDTOToEntity {

    public static GuitarEntity toEntity(GuitarDTO dto){
        GuitarEntity ret = new GuitarEntity();
        ret.setId(dto.getId());
        ret.setName(dto.getName());
        ret.setPrice(dto.getPrice());
        ret.setImgUrl(dto.getImgUrl());
        ret.setQuantity(dto.getQuantity());
        ret.setDescription(dto.getDescription());
        ret.setCategory(new GuitarCategoryEntity(dto.getCategory()));
        return ret;
    }
}
