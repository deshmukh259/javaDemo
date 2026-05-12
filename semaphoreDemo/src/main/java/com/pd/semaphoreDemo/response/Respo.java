package com.pd.semaphoreDemo.response;


import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpCookie;

import java.time.Instant;

@Getter
@Setter
public class Respo {

    private int id;
    private Object obj;
    private String value;
    private Instant time;


    public Respo(Integer id) {

        this.id = id;
        this.time = Instant.now();
    }
}
