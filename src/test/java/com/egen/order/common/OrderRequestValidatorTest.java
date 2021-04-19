package com.egen.order.common;

import com.egen.order.entity.ItemDetail;
import com.egen.order.entity.Order;
import com.egen.order.entity.ShippingAddress;
import com.egen.order.exception.OrderServiceException;
import com.egen.order.model.OrderDetail;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Set;

public class OrderRequestValidatorTest {

    @InjectMocks
    private OrderRequestValidator orderRequestValidator;

    @Before
    public void setUp()
    {

        MockitoAnnotations.initMocks(this);
    }

    @Test
   public void testInvalidOrder() {
        try {
            orderRequestValidator.validOrder(null);
        }catch (OrderServiceException e)
        {
            Assert.assertEquals("ORD-001",e.getErrorCode());
        }
    }
    @Test
    public void testShippingAddressMissing() {
        try {
            OrderDetail order = Mockito.mock(OrderDetail.class);
            Mockito.when(order.getShippingAddress()).thenReturn(null);
            orderRequestValidator.validOrder(order);
        }catch (OrderServiceException e)
        {
            Assert.assertEquals("ORD-002",e.getErrorCode());
        }
    }
    @Test
    public void testCustomerIdMissing() {
        try {
            OrderDetail order = Mockito.mock(OrderDetail.class);
            Mockito.when(order.getShippingAddress()).thenReturn(new ShippingAddress());
            Mockito.when(order.getCustomerId()).thenReturn(null);
            orderRequestValidator.validOrder(order);
        }catch (OrderServiceException e)
        {
            Assert.assertEquals("ORD-003",e.getErrorCode());
        }
    }
    @Test
    public void testItemDetailsMissing() {
        try {
            OrderDetail order = Mockito.mock(OrderDetail.class);
            Mockito.when(order.getShippingAddress()).thenReturn(new ShippingAddress());
            Mockito.when(order.getCustomerId()).thenReturn(1);
            Mockito.when(order.getItemDetails()).thenReturn(null);
            orderRequestValidator.validOrder(order);
        }catch (OrderServiceException e)
        {
            Assert.assertEquals("ORD-004",e.getErrorCode());
        }
    }
    @Test
    public void testValidOrder() {
            OrderDetail order = Mockito.mock(OrderDetail.class);
            Mockito.when(order.getShippingAddress()).thenReturn(new ShippingAddress());
            Mockito.when(order.getCustomerId()).thenReturn(1);
            ItemDetail itemDetail = Mockito.mock(ItemDetail.class);
            Set<ItemDetail> itemDetailSet = new HashSet<>();
            itemDetailSet.add(itemDetail);
            Mockito.when(order.getItemDetails()).thenReturn(itemDetailSet);
            orderRequestValidator.validOrder(order);
    }
}