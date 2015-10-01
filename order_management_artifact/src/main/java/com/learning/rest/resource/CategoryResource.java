package com.learning.rest.resource;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Created by amits on 24/09/15.
 */
@Setter
@Getter
public class CategoryResource {

    private String name;

    private String description;

    @JsonIgnore
    private List<ProductResource> products;
}
