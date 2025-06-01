package com.example.productcatalogservice.models;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity(name = "categories")
public class Category extends BaseModel{

    private String title;
    private String description;

    @OneToMany(fetch = jakarta.persistence.FetchType.LAZY, mappedBy = "category", cascade = CascadeType.REMOVE)
    private List<Product> products;

}
