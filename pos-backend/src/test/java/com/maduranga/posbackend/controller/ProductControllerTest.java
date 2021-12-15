
package com.maduranga.posbackend.controller;

import com.maduranga.posbackend.service.ProductService;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.Assert.*;

//@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @InjectMocks
    private ProductController productController;
/*
    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(productController).build();
    }*/

    @Test
    public void testGetProduct() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/v1/product/d001")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.pdesc", Matchers.is("Milo")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.pname", Matchers.is("Milo Drink")));
    }



}