package com.github.krystianmadra.guitarshop.guitar;

import com.github.krystianmadra.guitarshop.GuitarEntity;

public class GuitarDTOToEntity {

    public static GuitarEntity toEntity(GuitarDTO entity){
        GuitarEntity ret = new GuitarEntity();
        ret.setId(entity.getId());
        ret.setName(entity.getName());
        ret.setPrice(entity.getPrice());
        return ret;
    }
}
