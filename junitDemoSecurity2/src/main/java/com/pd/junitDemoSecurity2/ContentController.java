package com.pd.junitDemoSecurity2;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class ContentController {


    @GetMapping("/home")
    public String home() {
        return "home";

    }

    @GetMapping("/admin/home")
    public String homeAdmin() {
        return "home_admin";

    }

    @GetMapping("/user/home")
    public String homeUser() {
        return "home_user";

    }

    @GetMapping("/login")
    public String login() {
        return "custom_login";

    }


}
