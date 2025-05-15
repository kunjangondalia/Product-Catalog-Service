package com.example.productcatalogservice.dtos;


import com.example.productcatalogservice.models.Category;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class ProductDto {

    private int id;
    private String name;
    private String description;
    private double price;
    private String imageUrl;
    private Category category;

}
