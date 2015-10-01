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
        "description",
        "orderDate",
        "orderCustomer",
        "status",
        "billingAddress",
        "orderProduct"
})
@Getter
@Setter
public class OrderResource {
    @JsonProperty("id")
    private Long id;
    @JsonProperty("description")
    private String description;
    @JsonProperty("orderDate")
    private Long orderDate;
    @JsonProperty("orderCustomer")
    private OrderCustomer orderCustomer;
    @JsonProperty("status")
    private String status;
    @JsonProperty("billingAddress")
    private BillingResource billingAddress;
    @JsonProperty("orderProduct")
    private OrderProduct orderProduct;
}
