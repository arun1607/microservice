package com.learning.integration;

import com.learning.annotation.CircuitBreaker;
import com.learning.rest.resource.customer.CustomerBean;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * Created by amits on 30/09/15.
 */
@Component
public class CustomerServiceIntegration {

    @Autowired
    private RestTemplate restTemplate;

    @CircuitBreaker(fallbackMethod = "getDefaultCustomerBean")
    public CustomerBean getCustomerDetails(Long customerId) {
        ResponseEntity<CustomerBean> responseEntity = restTemplate.getForEntity("http://localhost:9090/customer/{id}", CustomerBean.class, customerId);
        return responseEntity.getBody();
    }

    public CustomerBean getDefaultCustomerBean(Long customerId) {
        return null;
    }
}
