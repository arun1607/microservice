package com.learning.rest.resource;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by amits on 28/09/15.
 */
@JsonPropertyOrder({
        "id",
        "orderId",
        "product",
        "vendor",
        "payment"
})
@Getter
@Setter
public class OrderBean {
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("orderId")
    private Integer orderId;
    @JsonProperty("product")
    private ProductBean product;
    @JsonProperty("vendor")
    private String vendor;
    @JsonProperty("payment")
    private Double payment;
}
