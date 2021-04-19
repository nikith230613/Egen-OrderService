package com.egen.order.service;

import com.egen.order.common.OrderRequestValidator;
import com.egen.order.dao.OrderRepository;
import com.egen.order.entity.ItemDetail;
import com.egen.order.entity.Order;
import com.egen.order.entity.ShippingAddress;
import com.egen.order.model.OrderDetail;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class OrderServiceImplTest {

    @InjectMocks
    private OrderServiceImpl orderService;

    @Mock
    private OrderRepository orderRepository;

    @Mock
    private OrderRequestValidator orderRequestValidator;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void getAllOrder() {
        List<Order>  orderList = new ArrayList<>();
        Order order = new Order();
        orderList.add(order);
        Mockito.when(orderRepository.findAll()).thenReturn(orderList);
        List<OrderDetail> result =  orderService.getAllOrder();
        Assert.assertEquals(1,result.size());

    }

    @Test
    void createOrder() {
        OrderDetail order = Mockito.mock(OrderDetail.class);
        Mockito.when(order.getShippingAddress()).thenReturn(new ShippingAddress());
        Mockito.when(order.getCustomerId()).thenReturn(1);
        ItemDetail itemDetail = Mockito.mock(ItemDetail.class);
        Set<ItemDetail> itemDetailSet = new HashSet<>();
        itemDetailSet.add(itemDetail);
        Mockito.when(order.getItemDetails()).thenReturn(itemDetailSet);
        orderService.create(order);
        Mockito.verify(orderRepository).save(Mockito.any());

    }

    @Test
    void getOrderDetail() {
        Order order = new Order();
        Mockito.when(orderRepository.findById(1L)).thenReturn(java.util.Optional.of(order));
        OrderDetail result =  orderService.getOrderDetail(1L);
        Assert.assertNotNull(result);
    }

    @Test
    void delete() {
        Order order = new Order();
        Mockito.when(orderRepository.findById(1L)).thenReturn(java.util.Optional.of(order));
        orderService.delete(1L);
        Mockito.verify(orderRepository).delete(Mockito.any());
    }

    @Test
    void cancelOrder() {
        Order order = new Order();
        Mockito.when(orderRepository.findById(1L)).thenReturn(java.util.Optional.of(order));
        orderService.cancelOrder(1L);
        Mockito.verify(orderRepository).save(Mockito.any());
    }
}