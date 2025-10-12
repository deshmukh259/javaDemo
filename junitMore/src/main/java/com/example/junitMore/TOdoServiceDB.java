package com.example.junitMore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TOdoServiceDB {

    @Autowired
    private TodoRepository todoRepository;


    public Todos create(String todo, String desc){
        Todos todos = new Todos();
        todos.setTodoName(todo);
        todos.setTodoDesc(desc);

        return todoRepository.save(todos);
    }


    public Todos get(String todo){
        return todoRepository.findByTodoName(todo);
    }



}
