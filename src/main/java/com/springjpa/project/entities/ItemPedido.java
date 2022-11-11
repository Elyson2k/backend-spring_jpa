package com.springjpa.project.entities;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@Entity
@EqualsAndHashCode
@NoArgsConstructor
@Table(name = "ITEM_PEDIDO")
public class ItemPedido implements Serializable{
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	ItemPedidoPK id = new ItemPedidoPK();
	
	private Double desconto;
	private Integer qtd;
	private Double price;
	
	public ItemPedido(Pedido pedido, Produto produto, Double desconto, Integer qtd, Double price) {
		id.setPedido(pedido);
		id.setProduto(produto);
		this.desconto = desconto;
		this.qtd = qtd;
		this.price = price;
	}
	
	public Pedido getPedido() {
		return id.getPedido();
	}
	
	public Produto getProduto() {
		return id.getProduto();
	}
	
}
