package com.learning.rest.resource;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by amits on 28/09/15.
 */
public class ProductBean {
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("productId")
    private Object productId;
    @JsonProperty("name")
    private String name;
    @JsonProperty("description")
    private String description;
}
