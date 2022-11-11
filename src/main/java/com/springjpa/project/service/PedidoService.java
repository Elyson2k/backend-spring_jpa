package com.springjpa.project.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springjpa.project.entities.Pedido;
import com.springjpa.project.repository.PedidoRepository;
import com.springjpa.project.service.exceptions.ObjectNotFoundException;

@Service
public class PedidoService {
	
	@Autowired
	private PedidoRepository repository;
	
	public Pedido find(Integer id) {
		Optional<Pedido> findPed = repository.findById(id);
		return findPed.orElseThrow( () -> new ObjectNotFoundException("ERROR: ID não se encontra no sistema."));
	}
	
}
