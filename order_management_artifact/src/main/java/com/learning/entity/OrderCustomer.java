package com.learning.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

/**
 * Created by amits on 22/09/15.
 */
@Entity
@Getter
@Setter
public class OrderCustomer extends BaseEntity{

    private Long customerId;

    private String name;

    private String email;

    @JsonIgnore
    @OneToMany(mappedBy = "orderCustomer")
    private List<Order> orders;
}
