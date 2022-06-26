package com.onura.homework1.controller;

import com.onura.homework1.entity.Product;
import com.onura.homework1.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductRepository productRepository;

    @PostMapping
    public Product save(@RequestBody Product product){
        return productRepository.save(product);
    }

    @GetMapping
    public List<Product> findAll(){
        return productRepository.findAll();
    }

    @GetMapping("expired/{currentDate}")
    public List<Product> findAllExpiredProducts(@PathVariable(value = "currentDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date currentDate){

        return productRepository.findAllProductByExpirationDateLessThan(currentDate);
    }

    @GetMapping("/{currentDate}")
    public List<Product> findAllNonExpiredProducts(@PathVariable(value = "currentDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date currentDate){

        return productRepository.findAllProductByExpirationDateIsGreaterThanEqualOrExpirationDateIsNull(currentDate);
    }

}
