package com.mateusmacial.todosystem.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mateusmacial.todosystem.domain.ToDo;
import com.mateusmacial.todosystem.dto.ToDoDTO;
import com.mateusmacial.todosystem.repositories.ToDoRepository;

@Service
public class ToDoService {

	@Autowired
	private ToDoRepository toDoRepository;
	
	public ToDo find(Integer id) {
		Optional<ToDo> obj = toDoRepository.findById(id);
		return obj.orElse(null);
		//Refatorar criando uma exceção personalizada para quando não encontrar.
	}
	
	public ToDo insert(ToDo obj) {
		obj.setId(null);
		return toDoRepository.save(obj);
	}
	
	public ToDo update(ToDo obj) {
		ToDo newObj = find(obj.getId());
		updateData(newObj, obj);
		return toDoRepository.save(newObj);
	}
	
	public ToDo fromDTO(ToDoDTO objDto) {
		return new ToDo(objDto.getId(), objDto.getDescricao(), objDto.getRealizada());
	}
	
	private void updateData(ToDo newObj, ToDo obj) {
		newObj.setDescricao(obj.getDescricao());
		newObj.setRealizada(obj.getRealizada());
	}
}