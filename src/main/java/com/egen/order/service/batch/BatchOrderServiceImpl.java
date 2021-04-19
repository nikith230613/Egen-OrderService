package com.egen.order.service.batch;

import com.egen.order.common.OrderConversionAdaptor;
import com.egen.order.dao.OrderRepository;
import com.egen.order.entity.Order;
import com.egen.order.model.OrderDetail;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class BatchOrderServiceImpl implements IBatchOrderService{
    @Autowired
    private OrderRepository orderRepository;

    @Override
    public void bulkOrderCreationOrUpdate(List<OrderDetail> orderDetails) {
        List<Order> orderList= new ArrayList<>();
        if(!CollectionUtils.isEmpty(orderDetails)) {
            orderDetails.forEach(order -> {
                Order orderEntity = new Order();
                BeanUtils.copyProperties(order, orderEntity);
                OrderConversionAdaptor.createDefaultValue(orderEntity);
                orderList.add(orderEntity);
            });
            orderRepository.saveAll(orderList);
        }
    }

}
