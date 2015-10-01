package com.learning.rest.resource;

import com.learning.entity.Address;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Created by amits on 27/09/15.
 */
@Getter
@Setter
public class CustomerResource {

    private Long customerId;

    private String firstName;

    private String lastName;

    private String email;

    private List<AddressResource> addresses;
}
