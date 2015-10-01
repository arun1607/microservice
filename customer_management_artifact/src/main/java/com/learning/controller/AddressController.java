package com.learning.controller;

import com.learning.entity.Address;
import com.learning.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by amits on 28/09/15.
 */
@RestController
@RequestMapping("/address")
public class AddressController {
    @Autowired
    private AddressRepository addressRepository;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    Address getOne(@PathVariable("id") Long id) {
        return addressRepository.findOne(id);
    }

}
