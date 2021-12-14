package com.mateusmacial.todosystem.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mateusmacial.todosystem.domain.ToDo;
import com.mateusmacial.todosystem.repositories.ToDoRepository;

@Service
public class ToDoService {

	@Autowired
	private ToDoRepository toDoRepository;
	
	public ToDo find(Integer id) {
		Optional<ToDo> obj = toDoRepository.findById(id);
		return obj.orElse(null);
	}
}