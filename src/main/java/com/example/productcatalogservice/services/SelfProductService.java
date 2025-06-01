package com.example.productcatalogservice.services;

import com.example.productcatalogservice.exceptions.CategoryNotFoundException;
import com.example.productcatalogservice.exceptions.ProductNotFoundException;
import com.example.productcatalogservice.models.Category;
import com.example.productcatalogservice.models.Product;
import com.example.productcatalogservice.repositories.CategoryRepository;
import com.example.productcatalogservice.repositories.ProductReopository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("selfProductService")
public class SelfProductService implements ProductService {

    private ProductReopository productRepository;
    private CategoryRepository categoryRepository;

    @Autowired
    public SelfProductService(ProductReopository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Product getSingleProduct(Long productId) throws ProductNotFoundException{
        Optional<Product> productOptional = productRepository.findById(productId);
        if (productOptional.isEmpty()) {
            throw new ProductNotFoundException(productId,"Product with id : "+productId+" doesn't exist");
        }

        return productOptional.get();
    }

    @Override
    public List<Product> getAllProducts() throws ProductNotFoundException {
        return productRepository.findAll();
    }

    @Override
    public Product createProduct(Product product) throws CategoryNotFoundException {

        Category category = product.getCategory();

        if(category == null){
            throw new CategoryNotFoundException("Product can't be created without category, Please try again with category.");
        }

        Optional<Category> optionalCategory = categoryRepository.findByTitle(category.getTitle());
        if(optionalCategory.isEmpty()){
            category = categoryRepository.save(category);
        }else{
            category = optionalCategory.get();
        }

        product.setCategory(category);
        product = productRepository.save(product);

        return product;
    }

    @Override
    public boolean deleteProduct(Long productId) throws ProductNotFoundException {
        Optional<Product> productOptional = productRepository.findById(productId);
        if (productOptional.isEmpty()) {
            throw new ProductNotFoundException(productId,"Product with id : "+productId+" doesn't exist");
        }
        productRepository.deleteById(productId);
        return false;
    }
}
