package com.example.student.controller;

import com.example.student.repository.StudentRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
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
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.List;
import static org.mockito.BDDMockito.given;
import org.hamcrest.Matchers;
import com.example.student.model.Student;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@RunWith(SpringRunner.class)
@WebMvcTest(StudentController.class)
public class StudentControllerTests {

        @Autowired
        MockMvc mockMvc;

        @MockBean
        StudentRepository studentRepository;

        @MockBean
        StudentController studentController;

        ObjectMapper om = new ObjectMapper();

        @Autowired
        private WebApplicationContext context;

        @Before
        public void setUp() {
                mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
        }


        @Test
        public void testGetAllStudent() throws Exception {

//                List<Student> list = new ArrayList<>();
//                list.add(new Student(1,"Kamale", 12,"ssssss"));
//                list.add(new Student(2,"Kaushlya", 12,"lllll"));
//                list.add(new Student(3,"Isuri", 12,"mmmmm"));
//
//                given(studentRepository.findAll()).willReturn(list);
//
//                mockMvc.perform(MockMvcRequestBuilders.get("/student/all")
//                                .accept(MediaType.APPLICATION_JSON))
//                        .andExpect(MockMvcResultMatchers.status().isOk())
//                        .andExpect(MockMvcResultMatchers.jsonPath("$[0].name", Matchers.is("Kamale")));

                var mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/student/")
                                .contentType(MediaType.APPLICATION_JSON)
                                .accept(MediaType.APPLICATION_JSON))
                        .andDo(print())
                        .andExpect(MockMvcResultMatchers.status().isOk())
                        .andReturn();
                System.out.println(mvcResult.getResponse().getContentAsString());
        }

        @Test
        public void testGetStudentByID() throws Exception {

                var mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/student/{studentId}",1)
                                .contentType(MediaType.APPLICATION_JSON)
                                .accept(MediaType.APPLICATION_JSON))
                        .andDo(print())
                        .andExpect(MockMvcResultMatchers.status().isOk())
                        .andReturn();
                System.out.println(mvcResult.getResponse().getContentAsString());

        }

        @Test
        public void testDeleteStudentByID() throws Exception {

                var mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/student/{studentId}",1)
                                .contentType(MediaType.APPLICATION_JSON)
                                .accept(MediaType.APPLICATION_JSON))
                        .andDo(print())
                        .andExpect(MockMvcResultMatchers.status().isOk())
                        .andReturn();
                System.out.println(mvcResult.getResponse().getContentAsString());

        }

  ////----------------------------------------

        @Test
        public void testUpdateStudentByID() throws Exception {

                ObjectMapper objectMapper = new ObjectMapper();
                String json = objectMapper.writeValueAsString(new Student(1,"Kamale", 12,"Minuwangoda"));
                var mvcResult = mockMvc.perform(MockMvcRequestBuilders.put("/student/{studentId}",1)
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(json)
                                .accept(MediaType.APPLICATION_JSON))
                        .andDo(print())
                        .andExpect(MockMvcResultMatchers.status().isOk())
                        .andReturn();
                System.out.println(mvcResult.getResponse().getContentAsString());

        }

        @Test
        public void testSaveStudentByID() throws Exception {

                ObjectMapper objectMapper = new ObjectMapper();
                String json = objectMapper.writeValueAsString(new Student(1,"Kamale", 12,"ssssss"));
                var mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/student/")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(json)
                                .accept(MediaType.APPLICATION_JSON))
                        .andDo(print())
                        .andExpect(MockMvcResultMatchers.status().isOk())
                        .andReturn();
                System.out.println(mvcResult.getResponse().getContentAsString());

        }



}

