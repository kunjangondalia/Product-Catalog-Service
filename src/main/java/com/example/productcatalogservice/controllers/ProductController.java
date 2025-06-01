package com.example.productcatalogservice.controllers;


import com.example.productcatalogservice.dtos.ExceptionDto;
import com.example.productcatalogservice.dtos.ProductDto;
import com.example.productcatalogservice.exceptions.CategoryNotFoundException;
import com.example.productcatalogservice.exceptions.ProductNotFoundException;
import com.example.productcatalogservice.models.Product;
import com.example.productcatalogservice.services.FakeStoreProductService;
import com.example.productcatalogservice.services.ProductService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    ProductService productService;

    public ProductController(@Qualifier("selfProductService") ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductDetailsById(@PathVariable long id) throws ProductNotFoundException{

        ResponseEntity<Product> responseEntity = new ResponseEntity<>(
                productService.getSingleProduct(id),
                HttpStatus.OK
        );

        return responseEntity;
    }

    @GetMapping("/{id}/{amount}")
    public ProductDto getProductWithIdAndPrice(@PathVariable long id, @PathVariable("amount") double price){
        ProductDto productDto = new ProductDto();
        productDto.setId(id);
        productDto.setPrice(price);
        return productDto;
    }

    @GetMapping("/")
    public List<Product> getAllProducts() throws ProductNotFoundException {
        return productService.getAllProducts();
    }

    @PostMapping("/")
    public Product createProduct(@RequestBody Product product) throws CategoryNotFoundException{
        product = productService.createProduct(product);
        return product;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable long id) throws ProductNotFoundException{
        productService.deleteProduct(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ExceptionDto> handleRuntimeException(){
        ExceptionDto exceptionDto = new ExceptionDto();
        exceptionDto.setMessage("Handling Exception within Controller");
        exceptionDto.setResolutionDetails("You need to pay everything you have to resolve this problem");
        return new ResponseEntity<>(exceptionDto, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
