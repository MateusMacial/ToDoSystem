package com.mateusmacial.todosystem.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mateusmacial.todosystem.domain.ToDo;

@RestController
@RequestMapping(value = "/todo")
public class ToDoResource {
	
	@RequestMapping(method=RequestMethod.GET)
	public List<ToDo> listar() {
		
		ToDo toDo1 = new ToDo(1, "Estudar", false);
		ToDo toDo2 = new ToDo(2, "Jogar", true);
		
		List<ToDo> lista = new ArrayList<>();
		
		lista.add(toDo1);
		lista.add(toDo2);
		
		return lista;
	}
}
