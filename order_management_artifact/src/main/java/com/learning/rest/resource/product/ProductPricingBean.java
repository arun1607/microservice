package com.learning.rest.resource.product;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by amits on 28/09/15.
 */
@Getter
@Setter
public class ProductPricingBean {
    @JsonProperty("id")
    public Long id;
    @JsonProperty("price")
    public Double price;
    @JsonProperty("discount")
    public Double discount;
}
