package com.springjpa.project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.springjpa.project.dto.ClienteDTO;
import com.springjpa.project.entities.Cliente;
import com.springjpa.project.repository.ClienteRepository;
import com.springjpa.project.service.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository repository;
	
	public List<Cliente> findAll(){
		List<Cliente> obj = repository.findAll();
		return obj;
	}
	
	public Cliente find(Integer id) {
		Optional<Cliente> findCli = repository.findById(id);
		return findCli.orElseThrow( () -> new ObjectNotFoundException("ERRO: ID não encontrado no sistema.") );
	}
	
	public Cliente update(Integer id, Cliente cat) {
		Optional<Cliente> obj = repository.findById(id);
		var categoria = obj.get();		
		categoria.setNome(cat.getNome());
		categoria.setEmail(cat.getEmail());		
		return repository.save(categoria);
	}
	
	public void delete(Integer id) {
		try {
			repository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new com.springjpa.project.service.exceptions.DataIntegrityViolationException("ERROR: Não é possivel excluir uma entidade que tem relações!");
		}
	}
	
	public Page<Cliente> findPage(Integer pages, Integer linesPerPage, String orderBy, String direction){
		PageRequest pageR = PageRequest.of(pages, linesPerPage, Direction.valueOf(direction), orderBy);
		return repository.findAll(pageR);
	}
	
	
	// ============================================================================================================================
	
		//                                                     FUNÇÕES / METODOS
		
		// ============================================================================================================================
	
		
	public Cliente fromDto(ClienteDTO obj) {
		return new Cliente(obj.getId(), obj.getNome(), obj.getEmail(), null, null);
	}
	
}
