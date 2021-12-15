package com.maduranga.posbackend.controller;

import com.maduranga.posbackend.dao.ProductRepo;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(SpringRunner.class)
@WebMvcTest(ProductController.class)
public class ProductControllerTests {

    private MockMvc mockMvc;
    @InjectMocks
    ProductController productController;
    @Mock
    ProductRepo productRepo;

    @Before
    public void setUp(){
        mockMvc = MockMvcBuilders.standaloneSetup(productController)
                .build();
    }

    @Test
    public void createProductAPI() throws Exception
    {

        String jsonString = "{\n" +
                "        \"pid\": \"m0011\",\n" +
                "        \"pname\": \"SamS Chicken Sausage 200G\",\n" +
                "        \"pdesc\": \"Sausages\",\n" +
                "        \"pprice\": 500.0,\n" +
                "        \"pimgurl\": \"https://objectstorage.ap-mumbai-1.oraclecloud.com/n/softlogicbicloud/b/cdn/o/products/600-600/118606--01--1613335103.jpeg\",\n" +
                "        \"category\": {\n" +
                "            \"cid\": \"M1\",\n" +
                "            \"cname\": \"Meet Products\"\n" +
                "        }\n" +
                "}";

        mockMvc.perform(MockMvcRequestBuilders.post("/addItem")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonString))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.pid", Matchers.is("m0011")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.pname",Matchers.is("SamS Chicken Sausage 200G")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.pdesc",Matchers.is("Sausages")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.pprice", Matchers.is(500.00)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.pimgurl",Matchers.is("https://objectstorage.ap-mumbai-1.oraclecloud.com/n/softlogicbicloud/b/cdn/o/products/600-600/118606--01--1613335103.jpeg")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.category[:1].cid",Matchers.is("M1")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.category[:1].cname",Matchers.is("Meet Products")));

    }

}
