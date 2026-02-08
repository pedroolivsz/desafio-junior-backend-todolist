package com.io.github.pedroolivsz.desafiojuniorbackendtodolist.controller;

import com.io.github.pedroolivsz.desafiojuniorbackendtodolist.entity.Todo;
import com.io.github.pedroolivsz.desafiojuniorbackendtodolist.service.TodoService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/todos")
public class TodoController {
    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @PostMapping("/create")
    public List<Todo> create(@RequestBody Todo todo) {
        return todoService.create(todo);
    }
}
