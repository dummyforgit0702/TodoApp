// src/main/java/com/example/todobackend/repository/TodoItemRepository.java
package com.example.todobackend.repository;
import com.example.todobackend.model.TodoItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoItemRepository extends JpaRepository<TodoItem, Long> {
    // JpaRepository provides CRUD methods like findAll(), findById(), save(), deleteById()
}

