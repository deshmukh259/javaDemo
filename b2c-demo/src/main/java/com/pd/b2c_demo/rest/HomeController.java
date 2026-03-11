package com.pd.b2c_demo.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home()
    {
        return "home.html";

    }

    @GetMapping("/time")
    @ResponseBody
    public long getTime(){
        return System.currentTimeMillis();
    }

    @GetMapping("/user")
    @ResponseBody
    public String getUser(){
        return "dfjdfjs-sdsb";
    }
}
