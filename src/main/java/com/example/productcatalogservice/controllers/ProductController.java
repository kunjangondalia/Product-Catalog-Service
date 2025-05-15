package com.example.productcatalogservice.controllers;


import com.example.productcatalogservice.dtos.ProductDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    @GetMapping("/{id}")
    public ProductDto getProductDetailsById(@PathVariable int id){
        ProductDto productDto = new ProductDto();
        productDto.setId(id);
        return productDto;
    }

    @GetMapping("/{id}/{amount}")
    public ProductDto getProductWithIdAndPrice(@PathVariable int id, @PathVariable("amount") double price){
        ProductDto productDto = new ProductDto();
        productDto.setId(id);
        productDto.setPrice(price);
        return productDto;
    }

    @GetMapping("/")
    public List<ProductDto> getAllProducts(){
        return new ArrayList<>();
    }

    @PostMapping("/")
    public ProductDto createProduct(@RequestBody ProductDto productDto){
        return productDto;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable int id){
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
