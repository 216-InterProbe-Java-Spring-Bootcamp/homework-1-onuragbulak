package com.onura.homework1.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.onura.homework1.entity.Customer;
import com.onura.homework1.entity.Product;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
public class ProductComment {

    @Id
    @GeneratedValue(generator = "ProductComment")
    @SequenceGenerator(name = "ProductComment",sequenceName = "PRODUCT_COMMENT_ID_SEQ")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_CUSTOMER", nullable = false, foreignKey = @ForeignKey(name = "FK_PRODUCT_COMMENT_CUSTOMER"))
    private Customer customer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_PRODUCT",nullable = false, foreignKey = @ForeignKey(name = "FK_PRODUCT_COMMENT_PRODUCT"))
    private Product product;

    @Column(name = "COMMENT", length = 500, nullable = false)
    private String comment;

    @Column(name = "COMMENT_DATE")
    @Temporal(TemporalType.DATE)
    private Date commentDate;
}
