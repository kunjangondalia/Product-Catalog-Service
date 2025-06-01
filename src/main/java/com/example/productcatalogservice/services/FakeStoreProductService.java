package com.example.productcatalogservice.services;

import com.example.productcatalogservice.dtos.FakeStoreProductDto;
import com.example.productcatalogservice.exceptions.ProductNotFoundException;
import com.example.productcatalogservice.models.Category;
import com.example.productcatalogservice.models.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class FakeStoreProductService implements ProductService{

    private RestTemplate restTemplate;

    public FakeStoreProductService(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }


    @Override
    public Product getSingleProduct(Long productId) {
        ResponseEntity<FakeStoreProductDto> productDtoResponseEntity = restTemplate.getForEntity(
                "https://fakestoreapi.com/products/"+productId,
                FakeStoreProductDto.class);

        FakeStoreProductDto fakeStoreProductDto = productDtoResponseEntity.getBody();
        return convertProductDtoToProduct(fakeStoreProductDto);
    }

    @Override
    public List<Product> getAllProducts() throws ProductNotFoundException {
        ResponseEntity<FakeStoreProductDto[]> productDtoResponseEntity = restTemplate.getForEntity(
                "https://fakestoreapi.com/products",
                FakeStoreProductDto[].class
        );

        FakeStoreProductDto[] fakeStoreProductDtos = productDtoResponseEntity.getBody();
        List<Product> products = new ArrayList<>();
        if(fakeStoreProductDtos == null){
            throw new ProductNotFoundException("Product Not found");
        }
        for (FakeStoreProductDto fakeStoreProductDto : fakeStoreProductDtos) {
            Product product = convertProductDtoToProduct(fakeStoreProductDto);
            products.add(product);
        }
        return products;
    }

    @Override
    public Product createProduct(Product product) {
        return null;
    }

    @Override
    public boolean deleteProduct(Long productId) {
        return false;
    }

    private Product convertProductDtoToProduct(FakeStoreProductDto fakeStoreProductDto){
        if(fakeStoreProductDto == null) return null;

        Product product = new Product();
        product.setId(fakeStoreProductDto.getId());
        product.setTitle(fakeStoreProductDto.getTitle());
        product.setDescription(fakeStoreProductDto.getDescription());
        product.setPrice(fakeStoreProductDto.getPrice());
        product.setImage(fakeStoreProductDto.getImage());
        Category category = new Category();
        category.setTitle(fakeStoreProductDto.getCategory());
        product.setCategory(category);

        return product;
    }
}
