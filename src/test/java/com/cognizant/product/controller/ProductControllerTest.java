package com.cognizant.product.controller;

import com.cognizant.product.ProductApplication;
import com.cognizant.product.dto.Product;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JacksonJsonParser;
import org.springframework.boot.json.JsonParser;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.Map;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by adisekhar on 4/2/18.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=ProductApplication.class)
@WebAppConfiguration
public class ProductControllerTest {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext context;

    @Before
    public void setUp() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.context)
                .build();
    }

    @Test
    public void getProducts() throws Exception {
    }

    @Test
    public void saveProduct() throws Exception {

        String request = "{\n" +
                "  \"price\":100,\n" +
                "  \"productId\": \"a1\",\n" +
                "  \"productName\": \"sa\"\n" +
                "}";

        this.mockMvc.perform(MockMvcRequestBuilders.post("/add")
                .content(request)
                .contentType("application/json"))
                .andExpect(jsonPath("$.productId").isString())
                .andExpect(jsonPath("$.productName").value("sa"))
                .andExpect(status().isCreated());

    }

}