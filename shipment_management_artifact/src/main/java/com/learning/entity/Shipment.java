package com.learning.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by amits on 24/09/15.
 */
@Entity
@Getter
@Setter
public class Shipment extends BaseEntity{

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private ShipmentAddress shipmentAddress;

    @Enumerated(EnumType.STRING)
    private DeliveryStatus status;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id")
    private ShipmentOrder shipmentOrder;

    @ManyToOne
    @JoinColumn(name = "logistic_id")
    private Logistic logistic;

}
