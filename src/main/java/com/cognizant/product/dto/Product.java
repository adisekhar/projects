package com.cognizant.product.dto;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by adisekhar on 3/29/18.
 */
@XmlRootElement
public class Product {

    private Integer productId;

    private String productName;

    private double price;

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
