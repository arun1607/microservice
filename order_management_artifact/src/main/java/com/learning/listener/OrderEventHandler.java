package com.learning.listener;

import com.learning.entity.OrderStatus;
import com.learning.event.Event;
import com.learning.event.EventType;
import com.learning.handler.EventHandler;
import com.learning.rest.resource.shipment.ShipmentBean;
import com.learning.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * Created by amits on 28/09/15.
 */
@Component("orderEventHandler")
public class OrderEventHandler implements EventHandler {

    @Autowired
    private RestTemplate restTemplate;


    @Autowired
    private OrderService orderService;

    @Override
    public void handleEvent(Event event) {

        EventType eventType = event.getEventType();
        Long eventId = event.getEventId();
        if (EventType.SHIPMENT_DELIVERED.equals(eventType)) {
            ShipmentBean shipmentBean = fetchShipmentDetails(eventId);
            orderService.updateOrder(shipmentBean, OrderStatus.COMPLETED);

        }
////            CreateOrderRequest orderResource = fetchShipmentDetails(eventId);
//            try {
//                inventoryService.createInventoryOrder(orderResource);
//            } catch (InsufficientItemStockException e) {
//                e.printStackTrace();
//            }
//        } else if (EventType.ORDER_FAILED.equals(eventType)) {
//            handleOrderFailure(event.getEventId());
//        } else if (EventType.ORDER_SUCCESS.equals(eventType)) {
//            handleOrderSuccess(event.getEventId());
//        }
    }

    private ShipmentBean fetchShipmentDetails(Long shipmentId) {
        ResponseEntity<ShipmentBean> responseEntity = restTemplate.getForEntity("http://localhost:9093/shipment/{id}", ShipmentBean.class, shipmentId);
        return responseEntity.getBody();
    }

//    private CreateOrderRequest fetchShipmentDetails(Long shipmentId) {
//        ResponseEntity<CreateOrderRequest> responseEntity = restTemplate.getForEntity("http://localhost:9092/order/{id}", CreateOrderRequest.class, orderId);
//        CreateOrderRequest orderResource = responseEntity.getBody();
//        return orderResource;
//        return null;
//    }
}
