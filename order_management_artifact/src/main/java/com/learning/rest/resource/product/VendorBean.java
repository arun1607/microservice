package com.learning.rest.resource.product;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by amits on 28/09/15.
 */
@Getter
@Setter
public class VendorBean {
    @JsonProperty("id")
    public Long id;
    @JsonProperty("name")
    public String name;
    @JsonProperty("email")
    public String email;
}
