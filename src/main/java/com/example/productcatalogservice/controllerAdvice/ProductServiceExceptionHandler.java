package com.example.productcatalogservice.controllerAdvice;

import com.example.productcatalogservice.dtos.ExceptionDto;
import com.example.productcatalogservice.dtos.ProductNotFoundExceptionDto;
import com.example.productcatalogservice.exceptions.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ProductServiceExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ExceptionDto> handleRuntimeExeption(){
        ExceptionDto exceptionDto = new ExceptionDto();
        exceptionDto.setMessage("Someting went wrong");
        exceptionDto.setResolutionDetails("You need to pay more money to resolve this problem");
        return new ResponseEntity<>(exceptionDto, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ProductNotFoundExceptionDto> handleNotFoundExeption(){
        ProductNotFoundExceptionDto exceptionDto = new ProductNotFoundExceptionDto();

        exceptionDto.setMessage("No product found");
        exceptionDto.setResolutionDetails("Enter product with a valid id");

        return new ResponseEntity<>(exceptionDto, HttpStatus.NOT_FOUND);
    }
}
