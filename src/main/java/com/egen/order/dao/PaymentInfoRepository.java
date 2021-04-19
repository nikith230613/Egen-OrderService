package com.egen.order.dao;

import com.egen.order.entity.PaymentInfo;
import com.egen.order.entity.ShippingAddress;
import org.springframework.data.repository.CrudRepository;

public interface PaymentInfoRepository extends CrudRepository<PaymentInfo, Long> {
}
