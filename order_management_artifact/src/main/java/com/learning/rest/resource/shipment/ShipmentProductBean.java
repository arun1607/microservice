package com.learning.rest.resource.shipment;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by amits on 28/09/15.
 */
@Getter
@Setter
public class ShipmentProductBean {

    @JsonProperty("id")
    private Long id;
    @JsonProperty("productId")
    private Long productId;
    @JsonProperty("name")
    private String name;
    @JsonProperty("description")
    private String description;

}
