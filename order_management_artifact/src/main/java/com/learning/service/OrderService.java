package com.learning.service;

import com.learning.entity.Order;
import com.learning.entity.OrderStatus;
import com.learning.exception.ExternalSystemUnreachableException;
import com.learning.rest.resource.CreateOrderRequest;
import com.learning.rest.resource.shipment.ShipmentBean;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by amits on 27/09/15.
 */
public interface OrderService {
    @Transactional
    Order placeOrder(CreateOrderRequest createOrderRequest) throws ExternalSystemUnreachableException;

    void updateOrder(ShipmentBean shipmentBean, OrderStatus completed);
}
