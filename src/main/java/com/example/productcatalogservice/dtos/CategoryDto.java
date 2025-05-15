package com.example.productcatalogservice.dtos;


import com.example.productcatalogservice.models.Product;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CategoryDto {

    private int id;
    private String name;
    private String description;
    private List<Product> products;
}
