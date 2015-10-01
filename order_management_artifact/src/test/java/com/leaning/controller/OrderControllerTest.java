package com.leaning.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.learning.OrderManagementServiceStarter;
import com.learning.controller.OrderController;
import com.learning.rest.resource.CreateOrderRequest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

/**
 * Created by amits on 27/09/15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = OrderManagementServiceStarter.class)
@TransactionConfiguration(defaultRollback = true)
public class OrderControllerTest {

    @Autowired
    private OrderController orderController;

    @Test
    public void testOrderCreation() throws Exception {
        CreateOrderRequest createOrderRequest = new CreateOrderRequest();
        createOrderRequest.setBillingAddressId(1L);
        createOrderRequest.setCustomerId(1L);
        createOrderRequest.setProductId(1L);
        createOrderRequest.setQuantity(4);
        ObjectMapper
                objectMapper = new ObjectMapper();
        String resource = objectMapper.writeValueAsString(createOrderRequest);
        System.out.println(resource);

        orderController.create(createOrderRequest);
    }
}
