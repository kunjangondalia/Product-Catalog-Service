package com.example.productcatalogservice.controllers;


import com.example.productcatalogservice.dtos.CategoryDto;
import org.springframework.web.bind.annotation.*;

@RestController
public class CategoryController {

    @GetMapping("/category/{id}")
    public CategoryDto getCategory(@PathVariable int id) {
        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setId(id);
        return categoryDto;
    }

    @PostMapping("/category")
    public CategoryDto createCategory(@RequestBody CategoryDto categoryDto) {
        return categoryDto;
    }
}
