package com.example.junitMore;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "todos")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Todos {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "todo_name",unique = true)
    private String todoName;

    @Column(name = "todo_desc")
    private String todoDesc;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTodoName() {
        return todoName;
    }

    public void setTodoName(String todoName) {
        this.todoName = todoName;
    }

    public String getTodoDesc() {
        return todoDesc;
    }

    public void setTodoDesc(String todoDesc) {
        this.todoDesc = todoDesc;
    }
}