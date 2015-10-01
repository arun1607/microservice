package com.learning.rest.resource.product;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by amits on 28/09/15.
 */
@Getter
@Setter
public class ProductBean {
    @JsonProperty("id")
    public Long id;
    @JsonProperty("name")
    public String name;
    @JsonProperty("description")
    public String description;
    @JsonProperty("category")
    public CategoryBean category;
    @JsonProperty("productDetail")
    public ProductDetailBean productDetail;
    @JsonProperty("productPricing")
    public ProductPricingBean productPricing;
}
