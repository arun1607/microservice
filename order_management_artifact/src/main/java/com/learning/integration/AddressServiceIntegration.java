package com.learning.integration;

import com.learning.annotation.CircuitBreaker;
import com.learning.rest.resource.customer.AddressBean;
import com.learning.rest.resource.customer.CustomerBean;
import com.learning.rest.resource.product.ProductBean;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * Created by amits on 30/09/15.
 */
@Component
public class AddressServiceIntegration {
    @Autowired
    private RestTemplate restTemplate;

    @CircuitBreaker(fallbackMethod = "getDefaultAddressBean")
    public AddressBean getAddressDetails(Long addressId) {
        ResponseEntity<AddressBean> addressBeanResponseEntity = restTemplate.getForEntity("http://localhost:9090/address/{id}", AddressBean.class, addressId);
        return addressBeanResponseEntity.getBody();
    }

    public AddressBean getDefaultAddressBean(Long addressId) {
        return null;
    }
}
