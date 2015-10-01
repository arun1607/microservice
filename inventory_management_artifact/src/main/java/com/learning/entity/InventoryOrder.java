package com.learning.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by amits on 27/09/15.
 */
@Entity
@Getter
@Setter
public class InventoryOrder extends BaseEntity {

    private Long orderId;

    @OneToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    private Integer quantity;
}
