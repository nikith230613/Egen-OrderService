package com.egen.order.controller;

import com.egen.order.entity.ItemDetail;
import com.egen.order.entity.Order;
import com.egen.order.entity.ShippingAddress;
import com.egen.order.model.OrderDetail;
import com.egen.order.service.OrderServiceImpl;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class OrderControllerTest {

    @InjectMocks
    private OrderController controller;

    @Mock
    private OrderServiceImpl orderService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void getOrders() {
        List<OrderDetail> orderList = new ArrayList<>();
        OrderDetail order = new OrderDetail();
        orderList.add(order);
        Mockito.when(orderService.getAllOrder()).thenReturn(orderList);
        List<OrderDetail> result =  controller.getOrders();
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
        controller.createOrder(order);
        Mockito.verify(orderService).create(Mockito.any());
    }

    @Test
    void deleteOrder() {
        OrderDetail order = new OrderDetail();
        Mockito.when(orderService.getOrderDetail(1L)).thenReturn( order);
        controller.deleteOrder(1L);
        Mockito.verify(orderService).delete(Mockito.any());
    }

    @Test
    void cancelOrder() {
        OrderDetail order = new OrderDetail();
        Mockito.when(orderService.getOrderDetail(1L)).thenReturn( order);
        controller.cancelOrder(1L);
        Mockito.verify(orderService).cancelOrder(Mockito.any());
    }

    @Test
    void getOrder() {
        OrderDetail order = new OrderDetail();
        Mockito.when(orderService.getOrderDetail(1L)).thenReturn(order);
        OrderDetail result =  controller.getOrder(1L);
        Assert.assertNotNull(result);
    }
}