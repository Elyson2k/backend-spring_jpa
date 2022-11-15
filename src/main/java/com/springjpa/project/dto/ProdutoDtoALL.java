package com.springjpa.project.dto;

import java.io.Serializable;

import com.springjpa.project.entities.Produto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class ProdutoDtoALL implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String nome;
	private Double preco;
	
	public ProdutoDtoALL(Produto obj) {
		id = obj.getId();
		nome = obj.getNome();
		preco = obj.getPreco();
	}
}
