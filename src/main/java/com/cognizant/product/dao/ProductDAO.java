package com.cognizant.product.dao;

import com.cognizant.product.dto.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by adisekhar on 3/29/18.
 */
@Component
public class ProductDAO {


    @Autowired
    JdbcTemplate jdbcTemplate;


    private static List<Product> listProduct = new ArrayList<Product>();

    class ProductRowMapper implements RowMapper<Product> {
        @Override
        public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
            Product product = new Product();
            product.setProductId(rs.getInt("productId"));
            product.setProductName(rs.getString("productName"));
            product.setPrice(rs.getDouble("price"));

            return product;
        }

    }

    public List<Product> getAllProducts() {

        return jdbcTemplate.query("select * from product", new ProductRowMapper());
        //return listProduct;
    }

    public Product addProduct(Product product) {
        jdbcTemplate.update("insert into product (productId, productName, price) " + "values(?,  ?, ?)",
                new Object[] { product.getProductId(), product.getProductName(), product.getPrice() });
        return  product;
    }

    public Product getProduct(String productId) {

        return jdbcTemplate.queryForObject("select * from product where productId=?", new Object[] { productId },
                new BeanPropertyRowMapper<>(Product.class));

       /* Optional<Product> product = listProduct.stream().filter(p -> p.getProductId().equals(productId)).findFirst();
        if(product.isPresent()) {
            return product.get();
        } else {
            return null;
        }*/
    }

    public int insert(Product product) {
        return jdbcTemplate.update("insert into product (productId, productId, price) " + "values(?,  ?, ?)",
                new Object[] { product.getProductId(), product.getProductName(), product.getPrice() });
    }

}
