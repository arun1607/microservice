package com.learning.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by amits on 21/09/15.
 */
@Entity
@Getter
@Setter
@Table(name = "shipment_order")
public class ShipmentOrder extends BaseEntity{

    private Long orderId;

    @OneToOne
    @JoinColumn(name = "product_id")
    private ShipmentProduct product;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    @JsonIgnore
    private ShipmentCustomer customer;

    private String vendor;

    private double payment;

}
