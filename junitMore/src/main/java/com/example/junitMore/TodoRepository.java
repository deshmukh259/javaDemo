package com.example.junitMore;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends JpaRepository<Todos, Integer> {
    Todos findByTodoName(String todo);
    //void findBytodoName(String todo);
}
