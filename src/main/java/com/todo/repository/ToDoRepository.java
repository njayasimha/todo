package com.todo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.todo.domain.ToDo;


@Repository
public interface ToDoRepository extends JpaRepository<ToDo, Long> {

}
