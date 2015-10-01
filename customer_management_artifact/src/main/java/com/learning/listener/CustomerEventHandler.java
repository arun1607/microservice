package com.learning.listener;

import com.learning.event.Event;
import com.learning.event.EventType;
import com.learning.handler.EventHandler;
import org.apache.camel.Consume;
import org.springframework.stereotype.Component;

/**
 * Created by amits on 28/09/15.
 */
@Component("customerEventHandler")
public class CustomerEventHandler implements EventHandler {

    @Override
    public void handleEvent(Event event) {
        EventType eventType = event.getEventType();
        if (EventType.ORDER_SUCCESS.equals(eventType)) {
            System.out.println("Order completed for order id : " + event.getEventId());
        }
    }
}
