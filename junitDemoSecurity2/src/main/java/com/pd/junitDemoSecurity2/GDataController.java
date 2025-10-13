package com.pd.junitDemoSecurity2;


import jakarta.websocket.server.PathParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GDataController {


    private final MyUserDetailsService userDetailsService;

    public GDataController(MyUserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @GetMapping("/protected/password/{user}")
    public String getPassword(@PathVariable("user") String user) {


        return userDetailsService.getPassword(user).getPassword();

    }


}
