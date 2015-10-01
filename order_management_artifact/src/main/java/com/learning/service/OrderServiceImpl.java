package com.learning.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.learning.entity.*;
import com.learning.event.Event;
import com.learning.event.EventType;
import com.learning.exception.ExternalSystemUnreachableException;
import com.learning.integration.AddressServiceIntegration;
import com.learning.integration.CustomerServiceIntegration;
import com.learning.integration.ProductServiceIntegration;
import com.learning.repository.OrderCustomerRepository;
import com.learning.repository.OrderRepository;
import com.learning.rest.resource.CreateOrderRequest;
import com.learning.rest.resource.customer.AddressBean;
import com.learning.rest.resource.customer.CustomerBean;
import com.learning.rest.resource.product.ProductBean;
import com.learning.rest.resource.product.VendorBean;
import com.learning.rest.resource.shipment.ShipmentBean;
import com.learning.rest.resource.shipment.ShipmentOrderBean;
import org.apache.camel.ExchangePattern;
import org.apache.camel.ProducerTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by amits on 27/09/15.
 */
@Service("orderService")
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderCustomerRepository orderCustomerRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ProducerTemplate producerTemplate;

    @Autowired
    private CustomerServiceIntegration customerServiceIntegration;

    @Autowired
    private ProductServiceIntegration productServiceIntegration;

    @Autowired
    private AddressServiceIntegration addressServiceIntegration;

    @Transactional
    @Override
    public Order placeOrder(CreateOrderRequest createOrderRequest) {
        Order order = createOrder(createOrderRequest);
        order = orderRepository.save(order);
        notifyListeners(order, EventType.ORDER_PLACED);
        StringBuilder stringBuilder = new StringBuilder("Order created for user ").append(order.getOrderCustomer().getName()).append(" for product ").append(order.getOrderProduct().getName()).append(" and for quantity ").append(order.getOrderProduct().getQuantity());
        stringBuilder.append(" and order id :").append(order.getId());
        System.out.println(stringBuilder);
        return order;
    }

    private Order createOrder(CreateOrderRequest createOrderRequest) {
        CustomerBean customerBean = getCustomerBean(createOrderRequest);
        ProductBean productBean = getProductBean(createOrderRequest);
        AddressBean addressBean = getAddressBean(createOrderRequest);
        if (customerBean == null || productBean == null || addressBean == null) {
            throw new ExternalSystemUnreachableException("Remote system is unreachable. Try after sometime");
        }
        Order order = new Order();
        order.setDescription("First order");
        Address billingAddress = convertToEntity(addressBean);
        order.setBillingAddress(billingAddress);
        order.setOrderDate(new Date());
        order.setStatus(OrderStatus.IN_PROCESS);

        OrderProduct orderProduct = convertToEntity(productBean);
        orderProduct.setQuantity(createOrderRequest.getQuantity());
        order.setOrderProduct(orderProduct);

        OrderCustomer orderCustomer = convertToEntity(customerBean);
        List<Order> orders = orderCustomer.getOrders();
        if (orders == null) {
            orders = new ArrayList<>();
        }
        orders.add(order);
        orderCustomer.setOrders(orders);
        orderCustomerRepository.save(orderCustomer);
        order.setOrderCustomer(orderCustomer);
        return order;
    }

    @Override
    @Transactional
    public void updateOrder(ShipmentBean shipmentBean, OrderStatus orderStatus) {
        ShipmentOrderBean shipmentOrderBean = shipmentBean.getShipmentOrder();
        Long orderId = shipmentOrderBean.getOrderId();
        Order order = orderRepository.findOne(orderId);
        order.setStatus(orderStatus);
        notifyListeners(order, EventType.ORDER_SUCCESS);
        StringBuilder stringBuilder = new StringBuilder("Order completed for user ").append(order.getOrderCustomer().getName()).append(" for product ").append(order.getOrderProduct().getName());
        stringBuilder.append(" and order id :").append(orderId);
        System.out.println(stringBuilder);
    }

    private AddressBean getAddressBean(CreateOrderRequest createOrderRequest) {
        Long billingAddressId = createOrderRequest.getBillingAddressId();
        return addressServiceIntegration.getAddressDetails(billingAddressId);
    }

    private ProductBean getProductBean(CreateOrderRequest createOrderRequest) {
        Long productId = createOrderRequest.getProductId();
        return productServiceIntegration.getProductDetails(productId);
    }

    private CustomerBean getCustomerBean(CreateOrderRequest createOrderRequest) {
        Long customerId = createOrderRequest.getCustomerId();
        return customerServiceIntegration.getCustomerDetails(customerId);
    }

    private void notifyListeners(Order order, EventType eventType) {
        Event event = new Event();
        event.setEventType(eventType);
        event.setEventId(order.getId());
        ObjectMapper objectMapper = new ObjectMapper();
        String message = null;
        try {
            message = objectMapper.writeValueAsString(event);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        producerTemplate.sendBody("activemq:topic:microservice", ExchangePattern.InOnly, message);
    }

    private OrderCustomer convertToEntity(CustomerBean customer) {
        OrderCustomer orderCustomer = new OrderCustomer();
        orderCustomer.setCustomerId(customer.getId());
        orderCustomer.setEmail(customer.getEmail());
        orderCustomer.setName(customer.getFirstName() + " " + customer.getLastName());
        return orderCustomer;
    }

    private Address convertToEntity(AddressBean addressResource) {
        Address address = new Address();
        address.setCity(addressResource.getCity());
        address.setLocality(addressResource.getLocality());
        address.setPinCode(addressResource.getPinCode());
        address.setState(addressResource.getState());
        return address;
    }

    private OrderProduct convertToEntity(ProductBean productBean) {
        OrderProduct orderProduct = new OrderProduct();
        orderProduct.setProductId(productBean.getId());
        orderProduct.setName(productBean.getName());
        orderProduct.setPrice(productBean.getProductPricing().getPrice());
        VendorBean vendorBean = productBean.getProductDetail().getVendor();

        if (vendorBean != null) {
            orderProduct.setVendor(vendorBean.getName());
        }
        return orderProduct;
    }

}
