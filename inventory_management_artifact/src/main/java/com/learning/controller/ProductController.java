package com.learning.controller;

import com.learning.entity.Product;
import com.learning.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by amits on 23/09/15.
 */
@RequestMapping("/product")
@RestController
public class ProductController {
    @Autowired
    private ProductRepository productRepository;

    @RequestMapping(method = RequestMethod.GET)
    List<Product> getAll() {
        return productRepository.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    Product getOne(@PathVariable("id") Long id) {
        return productRepository.findOne(id);
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    List<Product> search(@RequestParam("name") String productName) {
        return productRepository.findByName(productName);
    }
}