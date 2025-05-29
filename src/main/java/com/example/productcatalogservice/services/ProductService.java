package com.example.productcatalogservice.services;

import com.example.productcatalogservice.exceptions.ProductNotFoundException;
import com.example.productcatalogservice.models.Product;
import java.util.*;

public interface ProductService {
    Product getSingleProduct(Long productId);
    List<Product> getAllProducts() throws ProductNotFoundException;
    Product createProduct(Product product);
    boolean deleteProduct(Long productId);
}
