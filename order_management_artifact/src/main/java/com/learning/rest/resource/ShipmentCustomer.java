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
        "customerId",
        "name",
        "email"
})
@Getter
@Setter
public class ShipmentCustomer {
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("customerId")
    private Long customerId;
    @JsonProperty("name")
    private String name;
    @JsonProperty("email")
    private String email;
}
