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
        "email",
        "name"
})
@Getter
@Setter
public class OrderCustomer {

    @JsonProperty("id")
    private Long id;
    @JsonProperty("customerId")
    private Object customerId;
    @JsonProperty("email")
    private String email;
    @JsonProperty("name")
    private String name;
}
