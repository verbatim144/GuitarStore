package com.github.krystianmadra.guitarshop.order;

import com.github.krystianmadra.guitarshop.entities.OrderDetails;
import com.github.krystianmadra.guitarshop.guitar.GuitarDTO;

public class OrderDetailsEntityToDTO {

    public static OrderDetailsDTO toEntity(OrderDetails entity){
        OrderDetailsDTO ret = new OrderDetailsDTO();
        ret.setId(entity.getId());
        ret.setGuitar(entity.getGuitar().getId());
        ret.setOrderCode(entity.getOrderCode());
        ret.setQuantityOrdered(entity.getQuantityOrdered());
        ret.setSum(entity.getSum());

        return ret;
    }
}
