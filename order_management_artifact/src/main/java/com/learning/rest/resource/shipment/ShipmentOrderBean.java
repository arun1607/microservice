package com.learning.rest.resource.shipment;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by amits on 28/09/15.
 */
@Getter

@Setter
public class ShipmentOrderBean {

    @JsonProperty("id")
    private Long id;
    @JsonProperty("orderId")
    private Long orderId;
    @JsonProperty("product")
    private ShipmentProductBean product;
    @JsonProperty("vendor")
    private String vendor;
    @JsonProperty("payment")
    private Double payment;


}
