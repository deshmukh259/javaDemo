package com.example.junitMore;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class TodoControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    TOdoServiceDB todoService;

    @Autowired
    TodoRepository todoRepository;

    // @Mock
    // TodoService todoService;

    @BeforeEach
    public void clean() {
    todoRepository.deleteAll();
    }

    @Test
    void addTodo() throws Exception {

        String s = "todo 1";
        mockMvc.perform(post("/todo")
                        .param("text", s)
                        .param("description", "desc aaaa"))
                .andExpect(status().isOk())
                .andExpect(content().string(Matchers.containsString("todo")));

        mockMvc.perform(MockMvcRequestBuilders.get("/" + s))
                .andExpect(status().isOk())
                .andExpect(content().string(Matchers.containsString("aaaa")));


        Assertions.assertEquals(1, todoService);


    }

    @Test
    void addTodo1() throws Exception {

        String s = "todo 1";
        mockMvc.perform(post("/todo")
                        .param("text", s)
                        .param("description", "desc aaaa"))
                .andExpect(status().isOk())
                .andExpect(content().string(Matchers.containsString("todo")));

        mockMvc.perform(MockMvcRequestBuilders.get("/" + s))
                .andExpect(status().isOk())
                .andExpect(content().string(Matchers.containsString("aaaa")));


        Assertions.assertEquals(1, todoRepository.findAll().size());


    }

    @Test
    void addTodo2() throws Exception {

        String s = "todo 1";
        mockMvc.perform(post("/todo")
                        .param("text", s)
                        .param("description", "desc aaaa"))
                .andExpect(status().isOk())
                .andExpect(content().string(Matchers.containsString("todo")));

        mockMvc.perform(MockMvcRequestBuilders.get("/" + s))
                .andExpect(status().isOk())
                .andExpect(content().string(Matchers.containsString("aaaa")));


       // Assertions.assertEquals(1, todoService.);


    }


}
