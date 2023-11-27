package com.apo.PatronFactory.entity;

import lombok.Getter;
import lombok.Setter;

public class Product {

    @Getter
    @Setter
    private Long idProduct;

    @Getter
    @Setter
    private String productName;

    @Getter
    @Setter
    private double price;

    public Product(Long idProduct, String productName, double price) {
        this.idProduct = idProduct;
        this.productName = productName;
        this.price = price;
    }

}
