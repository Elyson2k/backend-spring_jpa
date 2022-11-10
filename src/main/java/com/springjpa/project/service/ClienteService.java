package com.springjpa.project.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springjpa.project.entities.Cliente;
import com.springjpa.project.repository.ClienteRepository;
import com.springjpa.project.service.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository repository;
	
	public Cliente find(Integer id) {
		Optional<Cliente> findCli = repository.findById(id);
		return findCli.orElseThrow( () -> new ObjectNotFoundException("ERRO: ID não encontrado no sistema.") );
	}
	
}
