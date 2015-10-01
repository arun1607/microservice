package com.learning.rest.resource;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by amits on 28/09/15.
 */
@Getter
@Setter
@JsonPropertyOrder({
        "id",
        "locality",
        "city",
        "state",
        "pinCode"
})
public class BillingResource {

    @JsonProperty("id")
    private Long id;
    @JsonProperty("locality")
    private String locality;
    @JsonProperty("city")
    private String city;
    @JsonProperty("state")
    private String state;
    @JsonProperty("pinCode")
    private String pinCode;
}
