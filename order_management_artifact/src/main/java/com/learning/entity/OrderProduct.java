package com.learning.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToOne;

/**
 * Created by amits on 21/09/15.
 */
@Entity
@Setter
@Getter
public class OrderProduct extends BaseEntity{

    private Long productId;

    private String name;

    private double price;

    private String vendor;

    private int quantity;

}
