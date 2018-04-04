package com.cognizant.product.bl;

import com.cognizant.product.dao.ProductDAO;
import com.cognizant.product.dto.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by adisekhar on 3/29/18.
 */
@Service
public class ProductManager {

    @Autowired
    private ProductDAO productDAO;

    public List<Product> getProducts() {
        return productDAO.getAllProducts();
    }

    public Product addProduct(Product product) {
        return productDAO.addProduct(product);
    }

    public Product showProduct(String productId) {
        return productDAO.showProduct(productId);
    }
}
