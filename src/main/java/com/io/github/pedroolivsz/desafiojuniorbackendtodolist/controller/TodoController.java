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

    @PutMapping("/update/{id}")
    public List<Todo> update(@PathVariable Long id, @RequestBody Todo todo) {
        return todoService.update(id, todo);
    }

    @GetMapping("/list")
    public List<Todo> list() {
        return todoService.list();
    }

    @DeleteMapping("/delete/{id}")
    public List<Todo> delete(@PathVariable Long id) {
        return todoService.delete(id);
    }
}
