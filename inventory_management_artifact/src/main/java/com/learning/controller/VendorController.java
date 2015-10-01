package com.learning.controller;

import com.learning.entity.Vendor;
import com.learning.repository.VendorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by amits on 27/09/15.
 */
@RequestMapping("/vendor")
@RestController
public class VendorController {

    @Autowired
    private VendorRepository vendorRepository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    List<Vendor> getAll() {
        return vendorRepository.findAll();
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    Vendor getOne(@PathVariable("id") Long id) {
        return vendorRepository.findOne(id);
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    List<Vendor> search(@RequestParam("name") String categoryName) {
        return vendorRepository.findByName(categoryName);
    }
}
