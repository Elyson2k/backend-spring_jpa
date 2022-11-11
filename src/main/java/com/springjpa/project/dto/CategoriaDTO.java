package com.springjpa.project.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.springjpa.project.entities.Categoria;
import com.springjpa.project.entities.Produto;

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
	@Length(min = 3, max = 25)
	@Column(name = "NOME")
	private String nome;
	
	private List<Produto> produtos = new ArrayList<>();
	
	public CategoriaDTO(Categoria obj) {
		id = obj.getId();
		nome = obj.getNome();
		produtos = obj.getProdutos();
	}
	
}
