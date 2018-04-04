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
       /* List<Product> productList = new ArrayList<>(2);
        Product product = new Product();
        product.setPrice(799);
        product.setProductId("IPh");
        product.setProductName("IPHONE 8");
        productList.add(product);
        product = new Product();
        product.setPrice(750);
        product.setProductId("SAM");
        product.setProductName("SAMSUNG 8");
        productList.add(product);*/
        return listProduct;
    }

    public Product addProduct(Product product) {
        listProduct.add(product);
        return  product;
    }

    public Product showProduct(String productId) {
        Optional<Product> showProduct = listProduct.stream().filter(p -> p.getProductId().equals(productId)).findFirst();
        if(showProduct.isPresent()) {
            return showProduct.get();
        } else {
            return null;
        }
    }

}
