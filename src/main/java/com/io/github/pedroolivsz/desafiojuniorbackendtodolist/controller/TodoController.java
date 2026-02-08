package com.io.github.pedroolivsz.desafiojuniorbackendtodolist.controller;

import com.io.github.pedroolivsz.desafiojuniorbackendtodolist.entity.Todo;
import com.io.github.pedroolivsz.desafiojuniorbackendtodolist.service.TodoService;
import org.springframework.web.bind.annotation.*;

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

    @PutMapping("/update")
    public List<Todo> update(@RequestBody Todo todo) {
        return todoService.update(todo);
    }

    @GetMapping("/list")
    public List<Todo> list() {
        return todoService.list();
    }

    @DeleteMapping("/delete")
    public List<Todo> delete(@RequestBody Long id) {
        return todoService.delete(id);
    }
}
