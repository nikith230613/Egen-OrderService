package com.egen.order.controller;

import com.egen.order.model.OrderDetail;
import com.egen.order.service.IOrderService;
import com.egen.order.service.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class OrderController {

    @Autowired
    private IOrderService orderService;

    @RequestMapping(value = "/orders", method = RequestMethod.GET)
    public List<OrderDetail> getOrders() {
        return orderService.getAllOrder();
    }

    @RequestMapping(value = "/order", method = RequestMethod.POST)
    public void createOrder(@RequestBody OrderDetail order) {
        orderService.create(order);
    }

    @RequestMapping(value = "/order/{id}", method = RequestMethod.DELETE)
    public void deleteOrder(@PathVariable("id") Long id) {
        orderService.delete(id);
    }

    @RequestMapping(value = "/order/cancel/{id}", method = RequestMethod.PUT)
    public void cancelOrder(@PathVariable("id") Long id) {
        orderService.cancelOrder(id);
    }

    @RequestMapping(value = "/order/{id}", method = RequestMethod.GET)
    public OrderDetail getOrder(@PathVariable("id") Long id) {
        return orderService.getOrderDetail(id);
    }

}
