package com.egen.order.common;

import com.egen.order.entity.ItemDetail;
import com.egen.order.entity.Order;
import com.egen.order.entity.ShippingAddress;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Set;

class OrderConversionAdaptorTest {


    @Before
    public void setUp()
    {

        MockitoAnnotations.initMocks(this);
    }
  /*  @Test
    void createDefaultValue() {
        Order order = Mockito.mock(Order.class);
        Mockito.when(order.getShippingAddress()).thenReturn(new ShippingAddress());
        Mockito.when(order.getCustomerId()).thenReturn(1);
        Mockito.when(order.getStatus()).thenReturn(null);
        ItemDetail itemDetail = Mockito.mock(ItemDetail.class);
        Set<ItemDetail> itemDetailSet = new HashSet<>();
        itemDetailSet.add(itemDetail);
        Mockito.when(order.getItemDetails()).thenReturn(itemDetailSet);
        Order newOrder =   OrderConversionAdaptor.createDefaultValue(order);
        Assert.assertEquals("CREATED",newOrder.getStatus());
    }*/
}