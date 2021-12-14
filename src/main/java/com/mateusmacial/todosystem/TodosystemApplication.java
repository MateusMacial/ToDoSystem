package com.mateusmacial.todosystem;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.mateusmacial.todosystem.domain.ToDo;
import com.mateusmacial.todosystem.repositories.ToDoRepository;

@SpringBootApplication
public class TodosystemApplication implements CommandLineRunner {

	@Autowired
	private ToDoRepository toDoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(TodosystemApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		ToDo toDo1 = new ToDo(null, "Estudar", false);
		ToDo toDo2 = new ToDo(null, "Trabalhar", false);
		
		toDoRepository.saveAll(Arrays.asList(toDo1, toDo2));
	}

}
