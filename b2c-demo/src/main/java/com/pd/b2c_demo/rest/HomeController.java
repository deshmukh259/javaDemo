package com.pd.b2c_demo.rest;

import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;

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
    @GetMapping("/user1")
    @ResponseBody
    public String getUser1(){
        return "dfjdfjs-sdsbds ";
    }

    @GetMapping("/login/oauth2/code/azure")
    @ResponseBody
    public String getUser3(){
        return "dfjdfjs-sdsbds ";
    }

    @GetMapping("/login/oauth2/code")
    @ResponseBody
    public String getUser4(){
        return "dfjdfjs-sdsbds ";
    }

    @GetMapping("/home")
    @ResponseBody
    public String home(Principal p){
        System.out.println("Log claims "+((OAuth2AuthenticationToken) p).getPrincipal().getAttributes());
        return "welcome home "+((OAuth2AuthenticationToken) p).getPrincipal().getAttributes().get("name");
    }


}
