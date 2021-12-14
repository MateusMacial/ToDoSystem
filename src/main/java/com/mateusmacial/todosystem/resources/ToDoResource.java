package com.mateusmacial.todosystem.resources;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.mateusmacial.todosystem.domain.ToDo;
import com.mateusmacial.todosystem.dto.ToDoDTO;
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
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody ToDoDTO objDto){ 
		ToDo obj = toDoService.fromDTO(objDto);
		obj = toDoService.insert(obj);
		URI uri = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(obj.getId())
				.toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody ToDoDTO objDto, @PathVariable Integer id){
		ToDo obj = toDoService.fromDTO(objDto);
		obj.setId(id);
		obj = toDoService.update(obj);
		return ResponseEntity.noContent().build();
	}
	
}
