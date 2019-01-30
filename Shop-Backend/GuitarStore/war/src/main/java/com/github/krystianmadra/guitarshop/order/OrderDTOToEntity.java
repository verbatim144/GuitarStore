package com.github.krystianmadra.guitarshop.order;

import com.github.krystianmadra.guitarshop.entities.GuitarEntity;
import com.github.krystianmadra.guitarshop.entities.OrderEntity;
import com.github.krystianmadra.guitarshop.entities.UserEntity;
import com.github.krystianmadra.guitarshop.guitar.GuitarDTOToEntity;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class OrderDTOToEntity {

    public static OrderEntity toEntity(OrderDTO dto){
        OrderEntity ret = new OrderEntity();
        ret.setUser(new UserEntity(dto.getUser()));
        ret.setTotalPrice(dto.getTotalPrice());
        Set<GuitarEntity> guitars = dto.getGuitars().stream().map(GuitarDTOToEntity::toEntity).collect(Collectors.toSet());
        ret.setGuitars(guitars);

        return ret;
    }
}
