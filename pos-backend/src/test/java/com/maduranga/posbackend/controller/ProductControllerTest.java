package com.maduranga.posbackend.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.maduranga.posbackend.model.Category;
import com.maduranga.posbackend.model.Product;
import com.maduranga.posbackend.service.ProductService;
import org.hamcrest.Matchers;
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

@RunWith(SpringRunner.class)
@WebMvcTest(ProductController.class)
public class ProductControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    ProductService productService;

    @Test
    public void testGetProduct() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/v1/product/d001")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
//                .andExpect(MockMvcResultMatchers.jsonPath("$.pdesc", Matchers.is("Milo")));
//                .andExpect(MockMvcResultMatchers.jsonPath("$.pname", Matchers.is("Milo Drink")));
    }

    @Test
    public void testAllProducts() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/v1/product/all")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testAddProduct() throws Exception {

        Product product = new Product();
        product.setPid("A001");
        product.setPname("Pelwatte");
        product.setPdesc("Pelwatte Milk");
        product.setPprice(350.0);
        product.setPimgurl("https://globalfoodcity.com/wp-content/uploads/2018/02/02-500x500.jpg");
        product.setPcatid("D1");

        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(product);

        mockMvc.perform(MockMvcRequestBuilders.get("/v1/product/save")
                        .accept(MediaType.APPLICATION_JSON)
                        .content(json)
                        .characterEncoding("utf-8"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testUpdateProduct() throws Exception {

        Category category = new Category();
        category.setCid("D1");
        category.setCname("Dairy Products");

        Product product = new Product();
        product.setPid("d001");
        product.setPname("Pelwatte");
        product.setPdesc("Pelwatte Milk");
        product.setPprice(350.0);
        product.setPimgurl("https://globalfoodcity.com/wp-content/uploads/2018/02/02-500x500.jpg");
        product.setPcatid("D1");
        product.setCategory(category);

        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(product);

        mockMvc.perform(MockMvcRequestBuilders.put("/v1/product/update/d001")
                        .accept(MediaType.APPLICATION_JSON)
                        .content(json)
                        .characterEncoding("utf-8"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testDeleteProduct() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/v1/product/delete/d002")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());

    }
}
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
//import org.mockito.Mockito;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.boot.test.json.JacksonTester;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@ExtendWith(MockitoExtension.class)
//public class ProductControllerTest {
//
//    private MockMvc mockMvc;
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
//    //private JacksonTester<Product> jsonProduct;
//
//    @BeforeEach
//    public void setup() {
//        JacksonTester.initFields(this, new ObjectMapper());
//        mockMvc = MockMvcBuilders.standaloneSetup(productController)
//                .build();
//    }
//
//    @Test
//    public void getProduct() throws Exception {
//
//        // given
//        given(productRepo.findById("d001"))
//                .willReturn(new Product("d001", "Milo","https://globalfoodcity.com/wp-content/uploads/2018/02/02-500x500.jpg","Milo Drink",65.0));
//
//        // when
//        MockHttpServletResponse response = mvc.perform(
//                        get("/superheroes/2")
//                                .accept(MediaType.APPLICATION_JSON))
//                .andReturn().getResponse();
//
//        // then
//        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
//        assertThat(response.getContentAsString()).isEqualTo(
//                jsonSuperHero.write(new SuperHero("Rob", "Mannon", "RobotMan")).getJson()
//        );
//    }
//
//}