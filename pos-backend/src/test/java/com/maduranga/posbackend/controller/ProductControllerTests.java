//package com.maduranga.posbackend.controller;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.maduranga.posbackend.dao.ProductRepo;
//import com.maduranga.posbackend.model.Product;
//import com.maduranga.posbackend.service.ProductService;
//import org.hamcrest.Matchers;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.boot.test.json.JacksonTester;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.hamcrest.Matchers.hasSize;
//import static org.mockito.BDDMockito.given;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@ExtendWith(MockitoExtension.class)
//public class ProductControllerTests {
//
//    private MockMvc mvc;
//
//    @Mock
//    private ProductRepo productRepo;
//
//    @Mock
//    private ProductService productService;
//
//    @InjectMocks
//    private ProductController productController;
//
//    private JacksonTester<Product> jsonSuperHero;
//
//    @BeforeEach
//    public void setup() {
//        JacksonTester.initFields(this, new ObjectMapper());
//        mvc = MockMvcBuilders.standaloneSetup(productController)
//                .build();
//    }
//
//    @Test
//    public void getALL() throws Exception {
//
//        List<Product> list = new ArrayList<>();
//
//        list.add(new Product("_01","Cake","Eat", 500));
//        list.add(new Product("_02","Milk","Drink", 65));
//        list.add(new Product("_03","Pen","Written", 20));
//
//        given(productRepo.findAll()).willReturn(list);
//        System.out.println();
//        mvc.perform(
//                        get("/product/all")
//                                .accept(MediaType.APPLICATION_JSON))
//                .andExpect(status().is(200))
//                .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(3)))
//                .andExpect(MockMvcResultMatchers.jsonPath("$[0].pname", Matchers.is("Cake")));
//
//    }
//
//}
package com.maduranga.posbackend.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.maduranga.posbackend.model.Product;
import com.maduranga.posbackend.service.CategoryService;
import com.maduranga.posbackend.service.ProductService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@RunWith(SpringRunner.class)
@WebMvcTest(ProductController.class)
public class ProductControllerTests{

    @Autowired
    MockMvc mockMvc;

    @MockBean
    ProductService productService;

    @MockBean
    CategoryService categoryService;

    @Test
    public void testUpdateProductByID() throws Exception {

        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(new Product("d001","Milo", "Milo Drink",50));
        mockMvc.perform(MockMvcRequestBuilders.put("/product/{pid}","d001")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();
    }

}