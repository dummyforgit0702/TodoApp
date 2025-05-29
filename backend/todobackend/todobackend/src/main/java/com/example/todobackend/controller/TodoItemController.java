// src/main/java/com/example/todobackend/controller/TodoItemController.java
package com.example.todobackend.controller;

import com.example.todobackend.model.TodoItem;
import com.example.todobackend.repository.TodoItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todos")
@CrossOrigin(origins = "http://localhost:3000") // Or your frontend URL
public class TodoItemController {

    @Autowired
    private TodoItemRepository todoItemRepository;

    // GET all todos
    @GetMapping
    public List<TodoItem> getAllTodos() {
        return todoItemRepository.findAll();
    }

    // POST a new todo
    @PostMapping
    public ResponseEntity<TodoItem> createTodo(@RequestBody TodoItem todoItem) {
        if (todoItem.getId() != null) {
            return ResponseEntity.badRequest().build();
        }
        TodoItem savedItem = todoItemRepository.save(todoItem);
        return new ResponseEntity<>(savedItem, HttpStatus.CREATED);
    }

    // Optional: GET a single todo by ID
    @GetMapping("/{id}")
    public ResponseEntity<TodoItem> getTodoById(@PathVariable Long id) {
        return todoItemRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build()); // This is fine as map(ResponseEntity::ok) infers TodoItem
    }

    // Optional: PUT (update) an existing todo
    @PutMapping("/{id}")
    public ResponseEntity<TodoItem> updateTodo(@PathVariable Long id, @RequestBody TodoItem todoDetails) {
        return todoItemRepository.findById(id)
                .map(existingTodo -> {
                    existingTodo.setTitle(todoDetails.getTitle());
                    existingTodo.setCompleted(todoDetails.isCompleted());
                    TodoItem updatedTodo = todoItemRepository.save(existingTodo);
                    return ResponseEntity.ok(updatedTodo);
                })
                .orElse(ResponseEntity.notFound().build()); // Fine for the same reason as GET /id
    }

    // Optional: DELETE a todo
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTodo(@PathVariable Long id) {
        return todoItemRepository.findById(id)
                .map(todo -> {
                    todoItemRepository.delete(todo);
                    return ResponseEntity.noContent().<Void>build(); // Or simply ResponseEntity.noContent().build();
                })
                .orElse(ResponseEntity.<Void>notFound().build()); // <--- THE FIX IS HERE
    }
}
