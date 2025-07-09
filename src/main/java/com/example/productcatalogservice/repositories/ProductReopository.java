package com.example.productcatalogservice.repositories;

import com.example.productcatalogservice.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface ProductReopository extends JpaRepository<Product, Long> {

//    @Query(value = "select * from products p where p.id = :id", nativeQuery = true)
//    Product findProductWithGivenId(@Param("id") Long productId);
}
