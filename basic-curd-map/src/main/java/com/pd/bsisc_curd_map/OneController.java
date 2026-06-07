package com.pd.bsisc_curd_map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class OneController {


    private Map<String, String> map = new HashMap<>();


    @GetMapping(value = "/set/{key}/{value}")
    public Map set(@PathVariable("key") String key, @PathVariable("value") String value) {

        map.put(key, value);
        return map;
    }

    @GetMapping(value = "/get/{key}")
    public String get(@PathVariable("key") String key) {
        return map.get(key);
    }

    @GetMapping(value = "/all")
    public Map getAll() {
        return map;
    }

    @GetMapping(value = "/delete/{key}")
    public Map delete(@PathVariable("key")  String key) {
        map.remove(key);
        return map;
    }

}
