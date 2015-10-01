package com.learning.rest.resource.customer;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by amits on 28/09/15.
 */
@Getter
@Setter
public class AddressBean {
    @JsonProperty("id")
    public Integer id;
    @JsonProperty("locality")
    public String locality;
    @JsonProperty("city")
    public String city;
    @JsonProperty("state")
    public String state;
    @JsonProperty("pinCode")
    public String pinCode;
}
