package com.learning.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.util.Date;

/**
 * Created by amits on 24/09/15.
 */
@Entity
@Setter
@Getter
public class ProductDetail extends BaseEntity{

    private String color;


    private String modelNumber;

    private Date manufacturingDate;

    @OneToOne
    @JoinColumn(name = "vendor_id")
    private Vendor vendor;

    @OneToOne
    @JoinColumn(name = "product_id")
    @JsonIgnore
    private Product product;
}
