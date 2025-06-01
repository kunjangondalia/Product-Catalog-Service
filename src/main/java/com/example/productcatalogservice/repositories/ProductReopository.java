package com.example.productcatalogservice.repositories;

import com.example.productcatalogservice.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductReopository extends JpaRepository<Product, Long> {
}
