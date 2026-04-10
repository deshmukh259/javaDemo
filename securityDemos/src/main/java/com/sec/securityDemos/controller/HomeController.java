package com.sec.securityDemos.controller;

import com.sec.securityDemos.config.AadClient;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class HomeController {

    @Autowired
    private AadClient aadClient;
    private final String Home_view_count= "HOME_VIEW_COUNT";
    @GetMapping("/")
    public String hello(Principal principal, HttpSession httpSession){

        incrementCount(httpSession,Home_view_count);
        System.out.println("Hello world");
        return "Hello "+principal.getName();
    }

    @GetMapping("/count")
    public String getCount(HttpSession session){
        System.out.println(aadClient.getUserId());
        System.out.println(aadClient.getConnection());
        System.out.println("ports "+aadClient.getConnection().getXcc().getPorts());
        System.out.println("ports "+aadClient.getConnection().getXcc().getVv());
        System.out.println("vv "+aadClient.getConnection().getXcc().getVv());
        return "COunt "+session.getAttribute(Home_view_count);
    }
    private void incrementCount(HttpSession httpSession, String attribute) {

       var v =  httpSession.getAttribute(attribute) == null ? 0 : (int) httpSession.getAttribute(attribute);

       httpSession.setAttribute(attribute,v+=1);

    }
}
