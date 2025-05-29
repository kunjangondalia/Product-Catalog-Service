package com.example.productcatalogservice.controllers;


import com.example.productcatalogservice.dtos.ProductDto;
import com.example.productcatalogservice.models.Product;
import com.example.productcatalogservice.services.FakeStoreProductService;
import com.example.productcatalogservice.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{id}")
    public Product getProductDetailsById(@PathVariable long id){
        Product product = productService.getSingleProduct(id);
        return product;
    }

    @GetMapping("/{id}/{amount}")
    public ProductDto getProductWithIdAndPrice(@PathVariable long id, @PathVariable("amount") double price){
        ProductDto productDto = new ProductDto();
        productDto.setId(id);
        productDto.setPrice(price);
        return productDto;
    }

    @GetMapping("/")
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
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
