package com.egen.order.controller.batch;

import com.egen.order.model.OrderDetail;
import com.egen.order.service.batch.IBatchOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class OrderBatchController {
    @Autowired
    private IBatchOrderService orderService;

    @RequestMapping(value = "/batch-create-orders", method = RequestMethod.POST)
    public void bulkCreateOrder(@RequestBody List<OrderDetail> order) {
        orderService.bulkOrderCreationOrUpdate(order);
    }

    @RequestMapping(value = "/batch-create-orders", method = RequestMethod.PUT)
    public void bulkUpdate(@RequestBody List<OrderDetail> order) {
        orderService.bulkOrderCreationOrUpdate(order);
    }
}
