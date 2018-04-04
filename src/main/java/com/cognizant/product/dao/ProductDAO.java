package com.cognizant.product.dao;

import com.cognizant.product.dto.Product;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by adisekhar on 3/29/18.
 */
@Component
public class ProductDAO {


    private static List<Product> listProduct = new ArrayList<Product>();

    public List<Product> getAllProducts() {
        return listProduct;
    }

    public Product addProduct(Product product) {
        listProduct.add(product);
        return  product;
    }

    public Product getProduct(String productId) {
        Optional<Product> product = listProduct.stream().filter(p -> p.getProductId().equals(productId)).findFirst();
        if(product.isPresent()) {
            return product.get();
        } else {
            return null;
        }
    }

}
