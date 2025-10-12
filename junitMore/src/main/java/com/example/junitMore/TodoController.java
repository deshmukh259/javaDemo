package com.example.junitMore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController

public class TodoController {


    @Autowired
    TOdoServiceDB tOdoServiceDB;

    @PostMapping("/todo")
    public Todos addTodo(@RequestParam("text") String text,
                         @RequestParam(name = "description", required = false) String description) {

        return tOdoServiceDB.create(text, description);
    }

    @GetMapping("/{todo}")
    public Todos get(@PathVariable String todo) {
        return tOdoServiceDB.get(todo);
    }


    @GetMapping("/hello")
    public String hello(){
        return "Hello java";
    }
}
