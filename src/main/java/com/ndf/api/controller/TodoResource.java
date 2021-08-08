package com.ndf.api.controller;

import com.ndf.api.model.Todo;
import com.ndf.api.service.HardcodedTodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3232")
@RestController
public class TodoResource {

    @Autowired
    private HardcodedTodoService hardcodedTodoService;

    @GetMapping("/users/{username}/todos")
    public List<Todo> getAllTodos(@PathVariable String username) {
        return hardcodedTodoService.getAllTodos();
    }

    @GetMapping("/users/{username}/todos/{id}")
    public Todo getTodoById(@PathVariable String username, @PathVariable long id){
        return hardcodedTodoService.findTodoById(id);
    }

    @PostMapping("/users/{username}/todos")
    public ResponseEntity<Void> createTodo(@PathVariable String username, @RequestBody Todo todo){
        Todo newTodo = hardcodedTodoService.saveTodo(todo);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("{/id}").buildAndExpand(newTodo.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/users/{username}/todos/{id}")
    public ResponseEntity<Todo> updateTodo(@PathVariable String username, @PathVariable long id, @RequestBody Todo todo){
        Todo updatedTodo = hardcodedTodoService.saveTodo(todo);
        return new ResponseEntity<Todo>(updatedTodo, HttpStatus.OK);
    }

    @DeleteMapping("/users/{username}/todos/{id}")
    public ResponseEntity<Void> deleteTodoById(@PathVariable String username, @PathVariable long id) {
        Todo todo = hardcodedTodoService.deleteTodoById(id);
        if (todo != null) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.noContent().build();
    }
}