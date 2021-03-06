package com.cognizant.product.dto;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by adisekhar on 3/29/18.
 */
@XmlRootElement
public class Catalog {

    private String productId;

    private String skuid;

    private String brand;

    private String ratings;

    private String productName;

    private double price;

    private Specification specification;

    private Warranty warranty;

    private Questions questions;

    private String productOverview;

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
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
