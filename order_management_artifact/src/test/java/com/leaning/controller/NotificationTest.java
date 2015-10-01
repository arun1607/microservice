package com.leaning.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.learning.OrderManagementServiceStarter;
import com.learning.event.Event;
import com.learning.event.EventType;
import org.apache.camel.ExchangePattern;
import org.apache.camel.ProducerTemplate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

/**
 * Created by amits on 28/09/15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = OrderManagementServiceStarter.class)
@TransactionConfiguration(defaultRollback = true)
public class NotificationTest {
    @Autowired
    private ProducerTemplate producerTemplate;

    @Test
    public void testSendingNotification() throws Exception {
        Event event
                = new Event();
        event.setEventType(EventType.ORDER_PLACED);
        event.setEventId(1L);
        ObjectMapper objectMapper = new ObjectMapper();
        String message = null;
        try {
            message = objectMapper.writeValueAsString(event);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        producerTemplate.sendBody("activemq:topic:microservice", ExchangePattern.InOnly, message);
    }
}
