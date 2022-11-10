package com.springjpa.project.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@EqualsAndHashCode
@NoArgsConstructor
@Entity
@Table(name = "PEDIDO")
public class Pedido implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Date instante;
	
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "pedido")
	private Pagamento pagamento;
	
	@ManyToOne
	@JoinColumn(name = "CLIENTE_ID")
	private Cliente cliente;
	
	@ManyToOne
	@JoinColumn(name = "ENDERECO_DE_ENTREGA_ID")
	private Endereco endereco;

	public Pedido(Integer id, Date instante, Cliente cliente, Endereco endereco) {
		this.id = id;
		this.instante = instante;
		this.cliente = cliente;
		this.endereco = endereco;
	}
	
	
}
