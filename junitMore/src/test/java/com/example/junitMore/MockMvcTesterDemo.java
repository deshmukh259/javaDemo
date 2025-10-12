package com.example.junitMore;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.servlet.assertj.MockMvcTester;
@SpringBootTest
@AutoConfigureMockMvc
public class MockMvcTesterDemo {

    @Autowired
    MockMvcTester tester;


    @Test
    void mmTester() {

        tester.get()
                .uri("/hello")
                .exchange()
                .assertThat()
                .hasStatus(HttpStatus.OK)
                .bodyText()
                .contains("java");

    }

    @Test
    public void mmpost(){

        tester.post()
                .uri("/todo?text=ABBAAX&description=B")
                .exchange()
                .assertThat()
                .hasStatus(HttpStatus.OK)
                .bodyText()
                .contains("B");


    }
}
