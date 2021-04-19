package com.egen.order.service;

import com.egen.order.model.OrderDetail;

import java.util.List;

public interface IOrderService {
    List<OrderDetail> getAllOrder();

    OrderDetail getOrderDetail(Long id);

    void create(OrderDetail order);



    void delete(Long id);

    void cancelOrder(Long id);
}
