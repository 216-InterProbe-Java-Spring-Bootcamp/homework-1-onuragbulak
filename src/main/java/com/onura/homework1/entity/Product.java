package com.onura.homework1.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.Date;

@Entity
@Getter
@Setter
public class Product {

    @Id
    @GeneratedValue(generator = "Product")
    @SequenceGenerator(name = "Product",sequenceName = "PRODUCT_ID_SEQ")
    private Long id;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "PRICE")
    private Float price;

    @Column(name = "EXPIRATION_DATE")
    @Temporal(TemporalType.DATE)
    private Date expirationDate;
}
