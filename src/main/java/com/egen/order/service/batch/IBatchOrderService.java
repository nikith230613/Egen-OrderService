package com.egen.order.service.batch;

import com.egen.order.model.OrderDetail;

import java.util.List;

public interface IBatchOrderService {

    void bulkOrderCreationOrUpdate(List<OrderDetail> orderDetails);
}
