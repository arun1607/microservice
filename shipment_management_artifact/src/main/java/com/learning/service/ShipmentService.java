package com.learning.service;

import com.learning.entity.Shipment;
import com.learning.rest.resource.OrderResource;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by amits on 28/09/15.
 */
public interface ShipmentService {

    Shipment createShipment(OrderResource orderResource);

    @Transactional
    void markCompleted();
}
