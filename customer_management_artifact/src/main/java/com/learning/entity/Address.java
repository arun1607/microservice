package com.learning.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class Address extends BaseEntity{


    private String locality;
    private String city;
    private String state;
    private String pinCode;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    @JsonIgnore
    private Customer customer;
}
