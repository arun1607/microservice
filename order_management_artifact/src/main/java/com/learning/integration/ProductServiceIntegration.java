package com.learning.integration;

import com.learning.annotation.CircuitBreaker;
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
public class ProductServiceIntegration {
    @Autowired
    private RestTemplate restTemplate;

    @CircuitBreaker(fallbackMethod = "getDefaultProductBean")
    public ProductBean getProductDetails(Long productId) {
        ResponseEntity<ProductBean> productResponseEntity = restTemplate.getForEntity("http://localhost:9091/product/{id}", ProductBean.class, productId);
        return productResponseEntity.getBody();
    }

    public ProductBean getDefaultProductBean(Long productId) {
        return null;
    }
}
