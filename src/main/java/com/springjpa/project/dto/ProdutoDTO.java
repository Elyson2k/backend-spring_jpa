package com.springjpa.project.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import com.springjpa.project.entities.ItemPedido;
import com.springjpa.project.entities.Produto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class ProdutoDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String nome;
	private Double preco;
	
	private Set<ItemPedido> itens = new HashSet<>();
	
	public ProdutoDTO(Produto obj) {
		id = obj.getId();
		nome = obj.getNome();
		preco = obj.getPreco();
		itens = obj.getItens();
	}
}
