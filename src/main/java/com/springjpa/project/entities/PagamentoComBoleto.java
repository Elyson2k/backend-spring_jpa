package com.springjpa.project.entities;

import java.util.Date;

import javax.persistence.Entity;

import com.springjpa.project.entities.enums.EstadoPagamento;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@Entity
public class PagamentoComBoleto extends Pagamento{
	private static final long serialVersionUID = 1L;
	
	private Date vencimento;
	private Date pagamento;
	
	public PagamentoComBoleto(Integer id, EstadoPagamento estadoPagamento, Pedido pedido, Date vencimento, Date pagamento) {
		super(id, estadoPagamento, pedido);
		this.vencimento = vencimento;
		this.pagamento = pagamento;
	}
	
	
}
