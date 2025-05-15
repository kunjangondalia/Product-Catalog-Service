package com.example.productcatalogservice.services;

import com.example.productcatalogservice.models.Product;
import java.util.*;

public interface ProductService {
    Product getSingleProduct(Long productId);
    List<Product> getAllProducts();
    Product createProduct(Product product);
    boolean deleteProduct(Long productId);
}
