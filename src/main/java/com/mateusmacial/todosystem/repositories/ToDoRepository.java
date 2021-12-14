package com.mateusmacial.todosystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mateusmacial.todosystem.domain.ToDo;

@Repository
public interface ToDoRepository extends JpaRepository<ToDo, Integer> {

	
}
