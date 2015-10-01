package com.learning.rest.resource;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by amits on 27/09/15.
 */
@Getter
@Setter
public class CreateOrderRequest {

    private Long productId;

    private Long customerId;

    private Long billingAddressId;

    private Integer quantity;
}
