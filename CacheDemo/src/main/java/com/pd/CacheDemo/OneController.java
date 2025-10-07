package com.pd.CacheDemo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OneController {

    @Autowired
    private ItemService itemService;

    @GetMapping("/get")
    public List<Item> getItems() {

        return itemService.getItems();
    }
}
