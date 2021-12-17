package com.maduranga.posbackend.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.maduranga.posbackend.dao.CategoryRepo;
import com.maduranga.posbackend.model.Category;
import com.maduranga.posbackend.service.CategoryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import static org.junit.Assert.*;
import static org.mockito.BDDMockito.*;


@ExtendWith(MockitoExtension.class)
class CategoryControllerTest {

    private MockMvc mockMvc;

    @Mock
    private CategoryRepo categoryRepo;

    @Mock
    private CategoryService categoryService;

    @InjectMocks
    private CategoryController categoryController;


    @BeforeEach
    public void setup() {
        JacksonTester.initFields(this, new ObjectMapper());
        mockMvc = MockMvcBuilders.standaloneSetup(categoryController)
                .build();
    }

    @Test
    public void getCategory() throws Exception {

        lenient().
        when(categoryRepo.findById("D1"))
                .thenReturn(java.util.Optional.of(new Category("D1", "Dairy Products")));


        MockHttpServletResponse response = mockMvc.perform(
                        get("/v1/categories/D1")
                                .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        System.out.println(response.getContentType());
       // assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
    }



}