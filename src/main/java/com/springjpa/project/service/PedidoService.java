package com.springjpa.project.service;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springjpa.project.entities.ItemPedido;
import com.springjpa.project.entities.PagamentoComBoleto;
import com.springjpa.project.entities.Pedido;
import com.springjpa.project.entities.enums.EstadoPagamento;
import com.springjpa.project.repository.ItemPedidoRepository;
import com.springjpa.project.repository.PagamentoRepository;
import com.springjpa.project.repository.PedidoRepository;
import com.springjpa.project.repository.ProdutoRepository;
import com.springjpa.project.service.exceptions.ObjectNotFoundException;

@Service
public class PedidoService {
	
	@Autowired
	private PedidoRepository repository;
	@Autowired
	private PagamentoRepository pagRepository;
	@Autowired
	private BoletoService boletoService;
	@Autowired
	private ProdutoRepository prodRepository;
	@Autowired
	private ItemPedidoRepository ipRepository;
	@Autowired
	private EmailService emailService;
	
	public Pedido find(Integer id) {
		Optional<Pedido> findPed = repository.findById(id);
		return findPed.orElseThrow( () -> new ObjectNotFoundException("ERROR: ID não se encontra no sistema."));
	}
	
	public Pedido insert(Pedido ped) {
		ped.setId(null);
		ped.setInstante(new Date());
		ped.getPagamento().setEstadoPagamento(EstadoPagamento.PENDENTE);
		ped.getPagamento().setPedido(ped); 
		if(ped.getPagamento() instanceof PagamentoComBoleto) {
			PagamentoComBoleto pagto = (PagamentoComBoleto) ped.getPagamento();
			boletoService.preencherPagamentoComBoleto(pagto, ped.getInstante());
		}
		ped = repository.save(ped);
		pagRepository.save(ped.getPagamento());
		for(ItemPedido ip : ped.getItens()) {
			ip.setDesconto(0.0);
			ip.setPrice(prodRepository.findById(ip.getProduto().getId()).get().getPreco());
			ip.setPedido(ped);
		}
		ipRepository.saveAll(ped.getItens());
		emailService.sendOrderConfirmationEmail(ped);
		return ped;
	}
	
}
