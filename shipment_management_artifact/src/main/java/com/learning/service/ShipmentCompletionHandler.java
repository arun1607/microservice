package com.learning.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.learning.entity.DeliveryStatus;
import com.learning.entity.Shipment;
import com.learning.event.Event;
import com.learning.event.EventType;
import com.learning.repository.ShipmentRepository;
import org.apache.camel.ExchangePattern;
import org.apache.camel.ProducerTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by amits on 28/09/15.
 */
@Component
public class ShipmentCompletionHandler {

    @Autowired
    private ShipmentService shipmentService;

    @Scheduled(fixedRate = 30000, initialDelay = 90000)
    @Transactional
    public void completeShipment() {
        shipmentService.markCompleted();

    }


}
