// src/main/java/com/example/todobackend/model/TodoItem.java
package com.example.todobackend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data; // If using Lombok
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Data // Lombok: Generates getters, setters, toString, equals, hashCode
@NoArgsConstructor // Lombok: Generates no-args constructor
@AllArgsConstructor // Lombok: Generates all-args constructor
public class TodoItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private boolean completed = false; // Default to false

    // If not using Lombok, you'd manually add:
    // public TodoItem() {}
    // public TodoItem(String title) { this.title = title; }
    // Getters and Setters for id, title, completed
    // toString(), equals(), hashCode()
}