package com.learning.rest.resource;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.learning.entity.BaseEntity;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by amits on 25/09/15.
 */
@Setter
@Getter
public class ProductPricingResource {

    private double price;

    private double discount;
}
