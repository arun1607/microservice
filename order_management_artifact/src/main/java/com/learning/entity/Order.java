package com.learning.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by amits on 21/09/15.
 */
@Entity
@Getter
@Setter
@Table(name = "purchase_order")
public class Order extends BaseEntity {

    private String description;

    private Date orderDate;

    @JoinColumn(name = "customer_id")
    @ManyToOne
    private OrderCustomer orderCustomer;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    @JoinColumn(name = "address_id")
    @OneToOne(cascade = CascadeType.ALL)
    private Address billingAddress;

    @JoinColumn(name = "product_id")
    @OneToOne(cascade = CascadeType.ALL)
    private OrderProduct orderProduct;


}
