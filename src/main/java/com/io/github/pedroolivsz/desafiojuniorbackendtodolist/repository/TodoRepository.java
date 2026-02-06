package com.io.github.pedroolivsz.desafiojuniorbackendtodolist.repository;

import com.io.github.pedroolivsz.desafiojuniorbackendtodolist.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Long> {
}
