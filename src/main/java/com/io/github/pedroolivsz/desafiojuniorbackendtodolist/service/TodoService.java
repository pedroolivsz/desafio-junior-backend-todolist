package com.io.github.pedroolivsz.desafiojuniorbackendtodolist.service;

import com.io.github.pedroolivsz.desafiojuniorbackendtodolist.entity.Todo;
import com.io.github.pedroolivsz.desafiojuniorbackendtodolist.repository.TodoRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {
    private TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public List<Todo> create(Todo todo) {
        todoRepository.save(todo);
        return list();
    }


    public List<Todo> update(Long id, Todo todo) {
        Todo existing = todoRepository.findById(id)
                        .orElseThrow(() -> new RuntimeException("Todo not found"));

        existing.setName(todo.getName());
        existing.setDescription(todo.getDescription());
        existing.setPrioridade(todo.getPrioridade());
        existing.setRealizado(todo.isRealizado());

        todoRepository.save(existing);
        return list();
    }

    public List<Todo> delete(Long id) {
        todoRepository.deleteById(id);
        return list();
    }

    public List<Todo> list() {
        Sort sort = Sort.by("prioridade").descending().and(
                Sort.by("name").ascending()
        );
        return todoRepository.findAll(sort);
    }
}
