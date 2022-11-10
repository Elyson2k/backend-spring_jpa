package com.springjpa.project.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.springjpa.project.entities.enums.EstadoPagamento;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@EqualsAndHashCode
@NoArgsConstructor
@Entity
@Table(name = "PAGAMENTO")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class  Pagamento implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	private Integer id;
	private Integer estadoPagamento;
	
	@MapsId
	@OneToOne
	@JoinColumn(name = "PEDIDO_ID")
	private Pedido pedido;

	public Pagamento(Integer id, EstadoPagamento estadoPagamento, Pedido pedido) {
		this.id = id;
		this.estadoPagamento = estadoPagamento.getCod();
		this.pedido = pedido;
	}
	
	
}
