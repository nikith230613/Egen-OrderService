package com.egen.order.controller.batch;

import com.egen.order.controller.OrderController;
import com.egen.order.entity.ItemDetail;
import com.egen.order.entity.ShippingAddress;
import com.egen.order.model.OrderDetail;
import com.egen.order.service.OrderServiceImpl;
import com.egen.order.service.batch.BatchOrderServiceImpl;
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

class OrderBatchControllerTest {
    @InjectMocks
    private OrderBatchController controller;

    @Mock
    private BatchOrderServiceImpl orderService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void bulkCreateOrder() {
        OrderDetail order = Mockito.mock(OrderDetail.class);
        Mockito.when(order.getShippingAddress()).thenReturn(new ShippingAddress());
        Mockito.when(order.getCustomerId()).thenReturn(1);
        ItemDetail itemDetail = Mockito.mock(ItemDetail.class);
        Set<ItemDetail> itemDetailSet = new HashSet<>();
        itemDetailSet.add(itemDetail);
        Mockito.when(order.getItemDetails()).thenReturn(itemDetailSet);
        List<OrderDetail> orderDetailList = new ArrayList<>();
        orderDetailList.add(order);
        controller.bulkCreateOrder(orderDetailList);
        Mockito.verify(orderService).bulkOrderCreationOrUpdate(Mockito.any());
    }

    @Test
    void bulkUpdate() {

        OrderDetail order = Mockito.mock(OrderDetail.class);
        Mockito.when(order.getShippingAddress()).thenReturn(new ShippingAddress());
        Mockito.when(order.getCustomerId()).thenReturn(1);
        ItemDetail itemDetail = Mockito.mock(ItemDetail.class);
        Set<ItemDetail> itemDetailSet = new HashSet<>();
        itemDetailSet.add(itemDetail);
        Mockito.when(order.getItemDetails()).thenReturn(itemDetailSet);
        List<OrderDetail> orderDetailList = new ArrayList<>();
        orderDetailList.add(order);
        controller.bulkUpdate(orderDetailList);
        Mockito.verify(orderService).bulkOrderCreationOrUpdate(Mockito.any());
    }
}