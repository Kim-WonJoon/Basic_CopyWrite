package com.example.copywriting.todo.repository;

import com.example.copywriting.todo.entiry.ToDo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ToDoRepository extends JpaRepository<ToDo, Long> {
}
