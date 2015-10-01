package com.learning.rest.resource.customer;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by amits on 28/09/15.
 */
@Getter
@Setter
public class CustomerBean {
    @JsonProperty("id")
    public Long id;
    @JsonProperty("firstName")
    public String firstName;
    @JsonProperty("lastName")
    public String lastName;
    @JsonProperty("email")
    public String email;
    @JsonProperty("addresses")
    public List<AddressBean> addresses = new ArrayList<AddressBean>();
}
