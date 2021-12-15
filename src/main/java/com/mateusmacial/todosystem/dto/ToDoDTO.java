package com.mateusmacial.todosystem.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.mateusmacial.todosystem.domain.ToDo;

public class ToDoDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	
	@NotEmpty(message = "Preenchimento obrigatório")
	@Length(min = 5, max = 120, message = "O tamanho deve ser entre 5 e 120 caracteres")
	private String descricao;
	
	private Boolean realizada;
	
	public ToDoDTO(){
	}
	
	public ToDoDTO(ToDo obj) {
		this.id = obj.getId();
		this.descricao = obj.getDescricao();
		this.realizada = obj.getRealizada();
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Boolean getRealizada() {
		return realizada;
	}
	public void setRealizada(Boolean realizada) {
		this.realizada = realizada;
	}
}
