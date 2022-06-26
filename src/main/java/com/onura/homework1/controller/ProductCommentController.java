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
    public List<ProductComment> findAllByProductId(@PathVariable Long id){
        return productCommentRepository.findAllByProductId(id);
    }

    @GetMapping("/customer/{id}")
    public List<ProductComment> findAllByCustomerId(@PathVariable Long id){
        return productCommentRepository.findAllByCustomerId(id);
    }

    @GetMapping("product/{startDate}/{endDate}/{id}")
    public List<ProductComment> findAllByProductIdAndCommentDate(@PathVariable Long id
                                                                             , @PathVariable(value = "startDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date commentDateStart
                                                                             , @PathVariable(value = "endDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date commentDateEnd){
        return productCommentRepository.findAllByProductIdAndCommentDateBetween(id,commentDateStart,commentDateEnd);
    }

    @GetMapping("customer/{startDate}/{endDate}/{id}")
    public List<ProductComment> findAllByCustomerIdAndCommentDate(@PathVariable Long id
                                                                              , @PathVariable(value = "startDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date commentDateStart
                                                                              , @PathVariable(value = "endDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date commentDateEnd){
        return productCommentRepository.findAllByCustomerIdAndCommentDateBetween(id,commentDateStart,commentDateEnd);
    }
}
