package com.example.junitMore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class TodoService {
    @Autowired
    Map<String, String> todoMap;

    public String addToddo(String text, String description) {

        todoMap.put(text, description);
        return text;
    }

    public String get(String todo) {

        return todoMap.get(todo);
    }
    public Map<String, String> map(){
        return todoMap;
    }

    public void clean() {
        todoMap.clear();
    }
}
