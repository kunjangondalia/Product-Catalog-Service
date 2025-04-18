package com.example.productcatalogservice.controllers;


import com.example.productcatalogservice.dtos.ProductDto;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {

    @GetMapping("/product/{id}")
    public ProductDto getProductDetailsById(@PathVariable int id){
        ProductDto productDto = new ProductDto();
        productDto.setId(id);
        return productDto;
    }

    @GetMapping("/product/{id}/{amount}")
    public ProductDto getProductWithIdAndPrice(@PathVariable int id, @PathVariable("amount") double price){
        ProductDto productDto = new ProductDto();
        productDto.setId(id);
        productDto.setPrice(price);
        return productDto;
    }

    @PostMapping("/product")
    public ProductDto createProduct(@RequestBody ProductDto productDto){
        return productDto;
    }
}
