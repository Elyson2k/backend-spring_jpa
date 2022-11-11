package com.springjpa.project.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;

import com.springjpa.project.entities.Categoria;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class CategoriaDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Column(name = "ID")
	private Integer id;

	@NotEmpty(message = "Campo não pode ser vazio!")
	@Column(name = "NOME")
	private String nome;
	
	public CategoriaDTO(Categoria obj) {
		id = obj.getId();
		nome = obj.getNome();
	}
	
}
