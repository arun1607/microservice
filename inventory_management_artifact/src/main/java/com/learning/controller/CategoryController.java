package com.learning.controller;

import com.learning.entity.Category;
import com.learning.repository.CategoryRepository;
import com.learning.rest.resource.CategoryResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by amits on 27/09/15.
 */
@RequestMapping("/category")
@RestController
public class CategoryController {
    @Autowired
    private CategoryRepository categoryRepository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    List<Category> getAll() {
        return categoryRepository.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    Category getOne(@PathVariable("id") Long id) {
        return categoryRepository.findOne(id);
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    List<Category> search(@RequestParam("name") String categoryName) {
        return categoryRepository.findByName(categoryName);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    Category add(CategoryResource categoryResource) {
        Category category = new Category();
        category.setDescription(categoryResource.getDescription());
        category.setName(categoryResource.getName());
        return categoryRepository.save(category);
    }
}
