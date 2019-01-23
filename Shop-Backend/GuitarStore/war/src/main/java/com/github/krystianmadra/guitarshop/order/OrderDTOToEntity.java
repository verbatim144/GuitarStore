package com.github.krystianmadra.guitarshop.order;

import com.github.krystianmadra.guitarshop.entities.OrderDetails;
import com.github.krystianmadra.guitarshop.entities.OrderEntity;
import com.github.krystianmadra.guitarshop.entities.UserEntity;
import com.github.krystianmadra.guitarshop.guitar.GuitarDTOToEntity;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class OrderDTOToEntity {

    public static OrderEntity toEntity(OrderDTO dto){
        OrderEntity ret = new OrderEntity();
        ret.setId(dto.getId());
        ret.setUser(new UserEntity(dto.getUser()));
        ret.setOrderDate(dto.getOrderDate());
        ret.setGuitars(new ArrayList<>());

        //List<OrderDetails> orderDetails = dto.getOrdersDetails().stream().map(OrderDetailsDTOToEntity::toEntity).collect(Collectors.toList());
        //ret.setOrdersDetails(orderDetails);

        return ret;
    }
}
