package com.maduranga.posbackend.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.maduranga.posbackend.dao.ProductRepo;
import com.maduranga.posbackend.model.Product;
import com.maduranga.posbackend.service.ProductService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
public class ProductControllerTests {

    private MockMvc mvc;

    @Mock
    private ProductRepo productRepo;

    @Mock
    private ProductService productService;

    @InjectMocks
    private ProductController productController;

    private JacksonTester<Product> jsonSuperHero;

    @BeforeEach
    public void setup() {
        JacksonTester.initFields(this, new ObjectMapper());
        mvc = MockMvcBuilders.standaloneSetup(productController)
                .build();
    }

    @Test
    public void getALL() throws Exception {
        String jsonString = "[\n" +
                "    {\n" +
                "        \"pid\": \"d001\",\n" +
                "        \"pname\": \"Milo Drink\",\n" +
                "        \"pdesc\": \"Milo\",\n" +
                "        \"pprice\": 65.0,\n" +
                "        \"pimgurl\": \"https://globalfoodcity.com/wp-content/uploads/2018/02/02-500x500.jpg\",\n" +
                "        \"category\": {\n" +
                "            \"cid\": \"D1\",\n" +
                "            \"cname\": \"Dairy Products\"\n" +
                "        }\n" +
                "    },\n" +
                "    {\n" +
                "        \"pid\": \"d002\",\n" +
                "        \"pname\": \"Anchor Drink\",\n" +
                "        \"pdesc\": \"Anchor\",\n" +
                "        \"pprice\": 60.0,\n" +
                "        \"pimgurl\": \"https://cdn.shopify.com/s/files/1/0020/9692/2735/products/anchor-newdale-uht-vanilla-milk-180ml-by-maharajasuper-com-684_300x300.png?v=1603360888\",\n" +
                "        \"category\": {\n" +
                "            \"cid\": \"D1\",\n" +
                "            \"cname\": \"Dairy Products\"\n" +
                "        }\n" +
                "    }\n" +
                "]";

        mvc.perform(MockMvcRequestBuilders.
                        get("/v1/product/all")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("[\n" +
                                "    {\n" +
                                "        \"pid\": \"d001\",\n" +
                                "        \"pname\": \"Milo Drink\",\n" +
                                "        \"pdesc\": \"Milo\",\n" +
                                "        \"pprice\": 65.0,\n" +
                                "        \"pimgurl\": \"https://globalfoodcity.com/wp-content/uploads/2018/02/02-500x500.jpg\",\n" +
                                "        \"category\": {\n" +
                                "            \"cid\": \"D1\",\n" +
                                "            \"cname\": \"Dairy Products\"\n" +
                                "        }\n" +
                                "    },\n" +
                                "    {\n" +
                                "        \"pid\": \"d002\",\n" +
                                "        \"pname\": \"Anchor Drink\",\n" +
                                "        \"pdesc\": \"Anchor\",\n" +
                                "        \"pprice\": 60.0,\n" +
                                "        \"pimgurl\": \"https://cdn.shopify.com/s/files/1/0020/9692/2735/products/anchor-newdale-uht-vanilla-milk-180ml-by-maharajasuper-com-684_300x300.png?v=1603360888\",\n" +
                                "        \"category\": {\n" +
                                "            \"cid\": \"D1\",\n" +
                                "            \"cname\": \"Dairy Products\"\n" +
                                "        }\n" +
                                "    }\n" +
                                "]"))
                .andDo(print())
                .andExpect(status().is(200))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].pname", Matchers.is("Milo Drink")));

    }

}
//package com.maduranga.posbackend.controller;

//import com.maduranga.posbackend.service.ProductService;
//import org.hamcrest.Matchers;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
//
//@RunWith(SpringRunner.class)
//@WebMvcTest(ProductController.class)
//public class ProductControllerTests{
//
//    @Autowired
//    MockMvc mockMvc;
//
//    @MockBean
//    ProductService productService;
//
//    @Test
//    public void testGetProduct() throws Exception {
//        mockMvc.perform(MockMvcRequestBuilders.get("/v1/product/d001")
//                        .accept(MediaType.APPLICATION_JSON))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(MockMvcResultMatchers.jsonPath("$.pdesc", Matchers.is("Milo")))
//                .andExpect(MockMvcResultMatchers.jsonPath("$.pname", Matchers.is("Milo Drink")));
//    }
//}