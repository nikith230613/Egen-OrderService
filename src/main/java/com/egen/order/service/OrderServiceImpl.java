package com.egen.order.service;

import com.egen.order.common.OrderConversionAdaptor;
import com.egen.order.common.OrderRequestValidator;
import com.egen.order.common.OrderStatus;
import com.egen.order.dao.OrderRepository;
import com.egen.order.entity.Order;
import com.egen.order.model.OrderDetail;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements IOrderService {

    @Autowired
    private OrderRepository orderRepository;


    @Autowired
    private OrderRequestValidator orderRequestValidator;

    public List<OrderDetail> getAllOrder() {
        List<OrderDetail> orderRecords = new ArrayList<>();
        Iterable<Order> orders = orderRepository.findAll();
        orders.forEach(order-> {
            OrderDetail orderDetail = new OrderDetail();
            BeanUtils.copyProperties(order,orderDetail);
            orderRecords.add(orderDetail);
        });
        return orderRecords;
    }

    public  OrderDetail getOrderDetail(Long id) {
        Optional<Order> order = orderRepository.findById(id);
        OrderDetail orderDetail = new OrderDetail();
        if(order.isPresent())
        {
            BeanUtils.copyProperties(order.get(),orderDetail);
        }
        return orderDetail;
    }

    public void create(OrderDetail order) {
        orderRequestValidator.validOrder(order);
        Order orderEntity = new Order();
        BeanUtils.copyProperties(order,orderEntity);
        orderEntity = OrderConversionAdaptor.createDefaultValue(orderEntity);
        orderRepository.save(orderEntity);
    }

    @Override
    public void delete(Long id) {
        Optional<Order> order = orderRepository.findById(id);
        if(order.isPresent())
        {
            // have to trigger payment service api to reverse payment
            orderRepository.delete(order.get());
        }
    }

    @Override
    public void cancelOrder(Long id) {
        Optional<Order> order = orderRepository.findById(id);
        if(order.isPresent())
        {
            // have to trigger payment service api to reverse payment
            Order orderTmp = order.get();
            orderTmp.setStatus(OrderStatus.CANCELLED.getStatus());
            orderRepository.save(orderTmp);
        }
    }
}
