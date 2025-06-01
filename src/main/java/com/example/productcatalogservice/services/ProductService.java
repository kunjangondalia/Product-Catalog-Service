package com.example.productcatalogservice.services;

import com.example.productcatalogservice.exceptions.CategoryNotFoundException;
import com.example.productcatalogservice.exceptions.ProductNotFoundException;
import com.example.productcatalogservice.models.Product;
import java.util.*;

public interface ProductService {
    Product getSingleProduct(Long productId) throws ProductNotFoundException;
    List<Product> getAllProducts() throws ProductNotFoundException;
    Product createProduct(Product product) throws CategoryNotFoundException;
    boolean deleteProduct(Long productId) throws ProductNotFoundException;
}
