package com.cognizant.product.controller;

import com.cognizant.product.bl.ProductManager;
import com.cognizant.product.dto.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * Created by adisekhar on 3/29/18.
 */
@RestController
@RequestMapping(value="/products")
public class ProductController {

    @Autowired
    private ProductManager productManager;

    @RequestMapping(method= RequestMethod.GET,
    produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity getProducts() {

        return ResponseEntity.ok( productManager.getProducts());
    }

    @RequestMapping(method= RequestMethod.POST,
    produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
    consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity saveProduct(@RequestBody Product product) {

        Product product1 = productManager.addProduct(product);
        return  ResponseEntity.status(HttpStatus.CREATED).body(product1);

    }

    @RequestMapping(value = "/{productId}", method= RequestMethod.GET,
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity getProduct(@PathVariable String productId) {

        Product product = productManager.getProduct(productId);
        return  ResponseEntity.ok(product);

    }
}
