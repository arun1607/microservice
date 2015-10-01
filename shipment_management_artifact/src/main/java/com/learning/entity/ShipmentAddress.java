package com.learning.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Created by amits on 22/09/15.
 */
@Entity
@Getter
@Setter
public class ShipmentAddress extends BaseEntity {
    private String locality;
    private String city;
    private String state;
    private String pinCode;

}
