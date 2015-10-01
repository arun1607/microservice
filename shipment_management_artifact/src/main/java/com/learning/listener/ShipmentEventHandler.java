package com.learning.listener;

import com.learning.event.Event;
import com.learning.event.EventType;
import com.learning.exception.InsufficientItemStockException;
import com.learning.handler.EventHandler;
import com.learning.rest.resource.OrderResource;
import com.learning.service.ShipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * Created by amits on 28/09/15.
 */
@Component("shipmentEventHandler")
public class ShipmentEventHandler implements EventHandler {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ShipmentService shipmentService;

    @Override
    public void handleEvent(Event event) {
        EventType eventType = event.getEventType();
        Long eventId = event.getEventId();
        if (EventType.ORDER_PLACED.equals(eventType)) {
            OrderResource orderResource = fetchOrderDetails(eventId);
            shipmentService.createShipment(orderResource);
        }
    }



    private OrderResource fetchOrderDetails(Long orderId) {
        ResponseEntity<OrderResource> responseEntity = restTemplate.getForEntity("http://localhost:9092/order/{id}", OrderResource.class, orderId);
        return responseEntity.getBody();
    }


}
