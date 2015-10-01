package com.learning.rest.resource.product;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.learning.entity.Vendor;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by amits on 28/09/15.
 */
@Getter
@Setter
public class ProductDetailBean {
    @JsonProperty("id")
    public Long id;
    @JsonProperty("color")
    public String color;
    @JsonProperty("modelNumber")
    public String modelNumber;
    @JsonProperty("manufacturingDate")
    public Long manufacturingDate;
    @JsonProperty("vendor")
    public VendorBean vendor;
}
