package com.ndf.api.service;

import com.ndf.api.model.Todo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class HardcodedTodoService {

    private static List<Todo> todos = new ArrayList<>();
    private static long idCounter = 0;

//    static {
//        todos.add(new Todo(++idCounter, "mayk89", "Learn to code with Java, React and Angular", new Date(), true));
//        todos.add(new Todo(++idCounter, "dan078", "Learn to code with .Net", new Date(), false));
//        todos.add(new Todo(++idCounter, "simeon126", "Learn to code with .Net and Java", new Date(), false));
//        todos.add(new Todo(++idCounter, "larysoft83", "Learn to code with Java and Angular", new Date(), true));
//    }

    public Todo saveTodo(Todo todo){
        if(todo.getId() == -1 || todo.getId() == 0){
            todo.setId(++idCounter);
            todos.add(todo);
        }else{
            deleteTodoById(todo.getId());
            todos.add(todo);
        }
        return todo;
    }

    public List<Todo> getAllTodos() {
        return todos;
    }

    public Todo findTodoById(long id) {
        for (Todo todo : todos) {
            if (todo.getId() == id) {
                return todo;
            }
            if (todo == null) {
                return null;
            }
        }
        return null;
    }

    public Todo deleteTodoById(long id) {
        Todo todo = findTodoById(id);

        if (todo == null) return null;

        if (todos.remove(todo)) {
            return todo;
        }
        return null;
    }
}