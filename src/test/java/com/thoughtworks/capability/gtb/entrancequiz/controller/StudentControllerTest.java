package com.thoughtworks.capability.gtb.entrancequiz.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;


import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class StudentControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void should_return_initial_student_list() throws Exception {
        mvc.perform(get("/students")).andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$", hasSize(15)))
                .andExpect(jsonPath("$[0]['id']").value(1))
                .andExpect(jsonPath("$[0]['name']").value("成吉思汗"))
                .andExpect(jsonPath("$[14]['id']").value(15))
                .andExpect(jsonPath("$[14]['name']").value("蔡文姬"));
    }

    @Test
    public void should_return_a_new_partition_of_students() throws Exception {
        mvc.perform(get("/students")).andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$", hasSize(15)));

        mvc.perform(post("/partition")).andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$", hasSize(6)))
                .andExpect(jsonPath("$[0]['team_name']").value("1 组"))
                .andExpect(jsonPath("$[0]['students_id']", hasSize(3)))
                .andExpect(jsonPath("$[1]['team_name']").value("2 组"))
                .andExpect(jsonPath("$[1]['student_id']", hasSize(3)))
                .andExpect(jsonPath("$[2]['team_name']").value("3 组"))
                .andExpect(jsonPath("$[2]['student_id']", hasSize(3)))
                .andExpect(jsonPath("$[3]['team_name']").value("4 组"))
                .andExpect(jsonPath("$[3]['student_id']", hasSize(2)))
                .andExpect(jsonPath("$[4]['team_name']").value("5 组"))
                .andExpect(jsonPath("$[4]['student_id']", hasSize(2)))
                .andExpect(jsonPath("$[5]['team_name']").value("6 组"))
                .andExpect(jsonPath("$[6]['student_id']", hasSize(2)));
    }


    @Test
    public void should_add_a_new_student() throws Exception {

        mvc.perform(get("/students")).andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$", hasSize(15)));

        mvc.perform(post("/student")
                .param("name", "哥斯拉")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        mvc.perform(get("/students"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$", hasSize(16)))
                .andExpect(jsonPath("$[15].id").value(16))
                .andExpect(jsonPath("$[15].name").value("哥斯拉"));
    }
}
