package com.mateusmacial.todosystem.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mateusmacial.todosystem.domain.ToDo;
import com.mateusmacial.todosystem.services.ToDoService;

@RestController
@RequestMapping(value = "/todo")
public class ToDoResource {
	
	@Autowired
	private ToDoService toDoService;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		
		ToDo obj = toDoService.find(id);
		
		return ResponseEntity.ok().body(obj);
	}
}
