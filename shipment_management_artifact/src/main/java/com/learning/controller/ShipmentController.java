package com.learning.controller;

import com.learning.entity.Shipment;
import com.learning.repository.ShipmentRepository;
import com.learning.rest.resource.OrderResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by amits on 28/09/15.
 */
@RequestMapping("/shipment")
@RestController
public class ShipmentController {
    @Autowired
    private ShipmentRepository shipmentRepository;


    @RequestMapping(method = RequestMethod.GET)
    public List<Shipment> getAll() {
        return shipmentRepository.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Shipment getOne(@PathVariable("id") Long id) {
        return shipmentRepository.findOne(id);
    }

}

