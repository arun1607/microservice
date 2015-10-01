package com.learning.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by amits on 21/09/15.
 */
@Entity
@Setter
@Getter
public class Product extends BaseEntity {

    private String name;

    private String description;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @OneToOne(mappedBy = "product",cascade = CascadeType.ALL)
    private ProductDetail productDetail;

    @OneToOne(mappedBy = "product",cascade = CascadeType.ALL)
    private ProductPricing productPricing;

}
