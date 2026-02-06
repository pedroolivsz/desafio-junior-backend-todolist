package com.io.github.pedroolivsz.desafiojuniorbackendtodolist.service;

import com.io.github.pedroolivsz.desafiojuniorbackendtodolist.entity.Todo;
import com.io.github.pedroolivsz.desafiojuniorbackendtodolist.repository.TodoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {
    private TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }
}
