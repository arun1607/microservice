package com.learning.rest.resource;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by amits on 27/09/15.
 */
@Getter
@Setter
public class AddressResource {
    private Long addressId;
    private String locality;
    private String city;
    private String state;
    private String pinCode;

}
