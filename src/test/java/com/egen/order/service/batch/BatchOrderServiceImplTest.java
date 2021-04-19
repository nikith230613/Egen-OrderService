package com.egen.order.service.batch;

import com.egen.order.dao.OrderRepository;
import com.egen.order.entity.ItemDetail;
import com.egen.order.entity.ShippingAddress;
import com.egen.order.model.OrderDetail;
import com.egen.order.service.OrderServiceImpl;
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

class BatchOrderServiceImplTest {

    @InjectMocks
    private BatchOrderServiceImpl orderService;

    @Mock
    private OrderRepository orderRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void bulkOrderCreationOrUpdate() {
        OrderDetail order = Mockito.mock(OrderDetail.class);
        Mockito.when(order.getShippingAddress()).thenReturn(new ShippingAddress());
        Mockito.when(order.getCustomerId()).thenReturn(1);
        ItemDetail itemDetail = Mockito.mock(ItemDetail.class);
        Set<ItemDetail> itemDetailSet = new HashSet<>();
        itemDetailSet.add(itemDetail);
        Mockito.when(order.getItemDetails()).thenReturn(itemDetailSet);
        List<OrderDetail> orderDetailList = new ArrayList<>();
        orderDetailList.add(order);
        orderService.bulkOrderCreationOrUpdate(orderDetailList);
        Mockito.verify(orderRepository).saveAll(Mockito.any());
    }
}