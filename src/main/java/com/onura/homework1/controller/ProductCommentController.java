package com.onura.homework1.controller;

import com.onura.homework1.repository.ProductCommentRepository;
import com.onura.homework1.entity.ProductComment;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/comment")
@RequiredArgsConstructor
public class ProductCommentController {

    private final ProductCommentRepository productCommentRepository;

    @PostMapping
    public ProductComment save(@RequestBody ProductComment productComment) {
        return productCommentRepository.save(productComment);
    }

    @GetMapping()
    public List<ProductComment> findAll(){
        return productCommentRepository.findAll();
    }

    @GetMapping("/product/{id}")
    public List<ProductComment> findAllProductCommentByProductId(@PathVariable Long id){
        return productCommentRepository.findAllProductCommentByProductId(id);
    }

    @GetMapping("/customer/{id}")
    public List<ProductComment> findAllProductCommentByCustomerId(@PathVariable Long id){
        return productCommentRepository.findAllProductCommentByCustomerId(id);
    }

    @GetMapping("product/{startDate}/{endDate}/{id}")
    public List<ProductComment> findAllProductCommentByProductIdAndCommentDate(@PathVariable Long id
                                                                             , @PathVariable(value = "startDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date commentDateStart
                                                                             , @PathVariable(value = "endDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date commentDateEnd){
        return productCommentRepository.findAllProductCommentByProductIdAndCommentDateBetween(id,commentDateStart,commentDateEnd);
    }

    @GetMapping("customer/{startDate}/{endDate}/{id}")
    public List<ProductComment> findAllProductCommentByCustomerIdAndCommentDate(@PathVariable Long id
                                                                              , @PathVariable(value = "startDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date commentDateStart
                                                                              , @PathVariable(value = "endDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date commentDateEnd){
        return productCommentRepository.findAllProductCommentByCustomerIdAndCommentDateBetween(id,commentDateStart,commentDateEnd);
    }
}
