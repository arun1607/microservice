package com.learning.rest.resource;

import com.learning.entity.BaseEntity;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by amits on 21/09/15.
 */
@Setter
@Getter
public class ProductResource extends BaseEntity {

    private String name;

    private String description;

    private CategoryResource category;

    private ProductDetailResource productDetail;

    private ProductPricingResource productPricing;

}
