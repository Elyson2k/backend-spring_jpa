package com.springjpa.project.entities;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

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

	@JsonIgnore
	@EmbeddedId
	ItemPedidoPK id = new ItemPedidoPK();
	
	private Double desconto;
	private Integer qtd;
	private Double price;
	
	public ItemPedido(Pedido pedido, Produto produto, Double desconto, Integer qtd, Double price) {
		id.setPedido(pedido);
		id.setProduto(produto);
		this.desconto = desconto;
		this.qtd = (qtd == null) ? null : qtd;
		this.price = price;
	}

	@JsonIgnore
	public Pedido getPedido() {
		return id.getPedido();
	}
	
	public Produto getProduto() {
		return id.getProduto();
	}
	
	public Double getSubTotal() {
		return (price - desconto) * qtd;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(getProduto().getNome());
		builder.append(", Qtd: ");
		builder.append(getQtd());
		builder.append(", Preço unitario: ");
		builder.append(getPrice());
		builder.append(", SubTotal: ");
		builder.append(getSubTotal());
		builder.append("\n");
		return builder.toString();
	}
	
	public void setPedido(Pedido pedido) {
		id.setPedido(pedido);
	}
	
	public void setProduto(Produto pro) {
		id.setProduto(pro);
	}


	
	
}
