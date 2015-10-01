package com.learning.controller;

import com.learning.entity.Address;
import com.learning.entity.Customer;
import com.learning.repository.CustomerRepository;
import com.learning.rest.resource.AddressResource;
import com.learning.rest.resource.CustomerResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by amits on 27/09/15.
 */
@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerRepository customerRepository;

    @RequestMapping(method = RequestMethod.GET)
    List<Customer> getAll() {
        return customerRepository.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    Customer getOne(@PathVariable("id") Long id) {
        return customerRepository.findOne(id);
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    List<Customer> search(@RequestParam("name") String name) {
        return customerRepository.findByFirstNameLikeOrLastNameLike(name, name);
    }

    @RequestMapping(method = RequestMethod.POST)
    Customer add(CustomerResource customerResource) {

        Customer customer = new Customer();
        customer.setFirstName(customerResource.getFirstName());
        customer.setLastName(customerResource.getLastName());
        customer.setEmail(customerResource.getEmail());
        List<Address> addresses = customerResource.getAddresses().stream().map(this::addressResourceToAddress).peek(address -> address.setCustomer(customer)).
                collect(Collectors.toList());
        customer.setAddresses(addresses);
        return customerRepository.save(customer);
    }

    private Address addressResourceToAddress(AddressResource addressResource) {
        Address address = new Address();
        address.setState(addressResource.getState());
        address.setPinCode(addressResource.getPinCode());
        address.setCity(addressResource.getCity());
        address.setLocality(addressResource.getLocality());
        return address;
    }

}
