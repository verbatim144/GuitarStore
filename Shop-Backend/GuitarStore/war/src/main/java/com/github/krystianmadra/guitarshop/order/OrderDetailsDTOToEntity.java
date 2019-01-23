package com.github.krystianmadra.guitarshop.order;

import com.github.krystianmadra.guitarshop.RandomOrderCode;
import com.github.krystianmadra.guitarshop.entities.GuitarEntity;
import com.github.krystianmadra.guitarshop.entities.OrderDetails;

public class OrderDetailsDTOToEntity {

    public static OrderDetails toEntity(OrderDetailsDTO dto){
        OrderDetails ret = new OrderDetails();
        ret.setId(dto.getId());
        ret.setGuitar(new GuitarEntity(dto.getId()));
        ret.setOrderCode(RandomOrderCode.randomString(5));
        ret.setQuantityOrdered(dto.getQuantityOrdered());
        ret.setSum(dto.getSum());

        return ret;
    }
}
