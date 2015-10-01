package com.learning.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.learning.entity.*;
import com.learning.event.Event;
import com.learning.event.EventType;
import com.learning.repository.LogisticRepository;
import com.learning.repository.ShipmentCustomerRepository;
import com.learning.repository.ShipmentProductRepository;
import com.learning.repository.ShipmentRepository;
import com.learning.rest.resource.BillingResource;
import com.learning.rest.resource.OrderCustomer;
import com.learning.rest.resource.OrderProduct;
import com.learning.rest.resource.OrderResource;
import com.learning.service.ShipmentService;
import org.apache.camel.ExchangePattern;
import org.apache.camel.ProducerTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by amits on 28/09/15.
 */
@Service
public class ShipmentServiceImpl implements ShipmentService {

    @Autowired
    ProducerTemplate producerTemplate;

    @Autowired
    private ShipmentRepository shipmentRepository;

    @Autowired
    private LogisticRepository logisticRepository;

    @Autowired
    private ShipmentCustomerRepository shipmentCustomerRepository;

    @Autowired
    private ShipmentProductRepository shipmentProductRepository;

    @Override
    public Shipment createShipment(OrderResource orderResource) {

        ShipmentAddress address = getBillingAddress(orderResource);
        ShipmentProduct product = getProduct(orderResource);
        shipmentProductRepository.save(product);
        ShipmentCustomer customer = getCustomer(orderResource);
        customer = shipmentCustomerRepository.save(customer);
        Logistic logistic = logisticRepository.findOne(1L);
        ShipmentOrder shipmentOrder = new ShipmentOrder();
        shipmentOrder.setOrderId(orderResource.getId());
        shipmentOrder.setCustomer(customer);
        shipmentOrder.setPayment(orderResource.getOrderProduct().getPrice());
        shipmentOrder.setProduct(product);
        shipmentOrder.setVendor(orderResource.getOrderProduct().getVendor());
        Shipment shipment = new Shipment();
        shipment.setLogistic(logistic);
        shipment.setShipmentAddress(address);
        shipment.setShipmentOrder(shipmentOrder);
        shipment.setStatus(DeliveryStatus.IN_TRANSIT);
        shipment = shipmentRepository.save(shipment);
        notifyListeners(shipment, EventType.SHIPMENT_CREATED);
        StringBuilder stringBuilder = new StringBuilder("Shipment created for user ").append(customer.getName()).append(" for product ").append(product.getName());
        stringBuilder.append(" and order id :").append(orderResource.getId());
        System.out.println(stringBuilder);
        return shipment;
    }

    private ShipmentCustomer getCustomer(OrderResource orderResource) {
        OrderCustomer orderCustomer = orderResource.getOrderCustomer();
        ShipmentCustomer customer = new ShipmentCustomer();
        customer.setName(orderCustomer.getName());
        customer.setEmail(orderCustomer.getEmail());
        customer.setCustomerId(orderCustomer.getId());
        return customer;

    }

    private ShipmentProduct getProduct(OrderResource orderResource) {

        OrderProduct orderProduct = orderResource.getOrderProduct();
        ShipmentProduct product = new ShipmentProduct();
        product.setDescription(orderResource.getDescription());
        product.setName(orderProduct.getName());
        return product;
    }

    private ShipmentAddress getBillingAddress(OrderResource orderResource) {
        BillingResource billingAddress = orderResource.getBillingAddress();
        ShipmentAddress address = new ShipmentAddress();
        address.setPinCode(billingAddress.getPinCode());
        address.setState(billingAddress.getState());
        address.setLocality(billingAddress.getLocality());
        address.setCity(billingAddress.getCity());

        return address;
    }

    private void notifyListeners(Shipment shipment, EventType eventType) {
        Event event = new Event();
        event.setEventType(eventType);
        event.setEventId(shipment.getId());
        ObjectMapper objectMapper = new ObjectMapper();
        String message = null;
        try {
            message = objectMapper.writeValueAsString(event);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        producerTemplate.sendBody("activemq:topic:microservice", ExchangePattern.InOnly, message);
    }

    @Override
    @Transactional
    public void markCompleted() {
        List<Shipment> shipmentList = shipmentRepository.findByStatus(DeliveryStatus.IN_TRANSIT);
        shipmentList.forEach(shipment -> {
            shipment.setStatus(DeliveryStatus.COMPLETED);
            StringBuilder stringBuilder = new StringBuilder("Shipment completed for user ").append(shipment.getShipmentOrder().getCustomer().getName()).append(" for product ").append(shipment.getShipmentOrder().getProduct().getName());
            stringBuilder.append(" and order id :").append(shipment.getShipmentOrder().getOrderId());
            System.out.println(stringBuilder);
            notifyListeners(shipment, EventType.SHIPMENT_DELIVERED);
        });
    }
}
