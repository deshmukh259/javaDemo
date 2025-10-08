package com.pd.CacheDemo;


import jdk.jshell.EvalException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OneController {

    @Autowired
    private ItemService itemService;

    @Value("${val1}")
    private String val1;
    @GetMapping("/get")
    public List<Item> getItems() {
        System.out.println("val = " + val1);
        return itemService.getItems();
    }
}
