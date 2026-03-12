package com.pd.b2c_demo.rest;

import org.springframework.security.access.prepost.PreAuthorize;
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

    @GetMapping("/secret")
    @PreAuthorize("hasAuthority('APP_WRITE')") //TODO this not working because roles[its user attribute] dont supported by spring sec
    // need to write own method to validate
    @ResponseBody
    public String secret(Principal p){
    System.out.println("Secret api "+((OAuth2AuthenticationToken) p).getPrincipal().getAttributes());
        return "Secret endpoint access by APP-WRITE user  "+((OAuth2AuthenticationToken)p).getPrincipal().getAttributes().get("name");
    }


    @GetMapping("/home")
    @ResponseBody
    public String home(Principal p){
        System.out.println("Log claims "+((OAuth2AuthenticationToken) p).getPrincipal().getAttributes());
        return "welcome home "+((OAuth2AuthenticationToken) p).getPrincipal().getAttributes().get("name");
    }



}
