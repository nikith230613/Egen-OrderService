package com.egen.order.dao;

import com.egen.order.entity.BillingAddress;
import com.egen.order.entity.ItemDetail;
import org.springframework.data.repository.CrudRepository;

public interface ItemRepository extends CrudRepository<ItemDetail, Long> {
}
