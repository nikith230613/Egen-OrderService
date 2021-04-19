package com.egen.order.common;

import com.egen.order.entity.ItemDetail;
import com.egen.order.entity.Order;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class OrderConversionAdaptor {

    public static Order createDefaultValue(Order order)
    {
        if(order!=null) {
            order.setCreationDateAndTime(Timestamp.from(Instant.now()));
            order.setUpdateDateAndTime(Timestamp.from(Instant.now()));
            if(order.getStatus()==null) {
                order.setStatus(OrderStatus.CREATED.getStatus());
            }
            if (!CollectionUtils.isEmpty(order.getItemDetails())) {
                Set<ItemDetail> itemDetailSet =    order.getItemDetails().stream().map(item->{
                    item.setCreationDateAndTime(Timestamp.from(Instant.now()));
                    item.setUpdateDateAndTime(Timestamp.from(Instant.now()));
                    item.setUser(order.getUser());
                    return item;
                }).collect(Collectors.toSet());
                order.setItemDetails(itemDetailSet);
            }
        }
        return  order;
    }
}
