package com.example.junitMore;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.verification.VerificationMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.assertj.MockMvcTester;

@WebMvcTest(controllers = TodoController.class)
//adding controller here only load this one o=not others
@Import(TOdoServiceDB.class)
//adding import of service is now caling actual service obj n ot mock any more
// but will need to mock repo
public class WebMvcTestDemo {

    //look all controller

    // all beans


    @Autowired
    MockMvcTester mock;

    @MockitoBean
    TodoRepository todoRepository;
    @Test
    public void testt(){
        mock.get()
                .uri("/hello")
                .exchange()
                .assertThat()
                .hasStatus(HttpStatus.OK)
                .bodyText().contains("Hello");

        Mockito.verify(todoRepository).findByTodoName("hell");
    }


}
