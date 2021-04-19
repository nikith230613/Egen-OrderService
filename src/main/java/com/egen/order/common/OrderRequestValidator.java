package com.egen.order.common;

import com.egen.order.exception.OrderServiceException;
import com.egen.order.model.OrderDetail;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

@Component
public class OrderRequestValidator {

    public void validOrder(OrderDetail order) {
        if(order==null) {
            throw new OrderServiceException(ErrorCode.INVALID_ORDER);
        }
        if(order.getShippingAddress()==null) {
            throw new OrderServiceException(ErrorCode.SHIPPING_ADDRESS_MANDATORY);
        }
        if(order.getCustomerId()==null) {
            throw new OrderServiceException(ErrorCode.CUSTOMER_ID_MANDATORY);
        }
        if(order.getItemDetails()==null || CollectionUtils.isEmpty(order.getItemDetails())) {
            throw new OrderServiceException(ErrorCode.ITEM_DETAIL_MANDATORY);
        }
    }
}
