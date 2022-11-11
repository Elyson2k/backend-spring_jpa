package com.springjpa.project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springjpa.project.dto.CategoriaDTO;
import com.springjpa.project.entities.Categoria;
import com.springjpa.project.repository.CategoriaRepository;
import com.springjpa.project.service.exceptions.DataIntegrityViolationException;
import com.springjpa.project.service.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public Categoria find(Integer id) {
		Optional<Categoria> findCategoria = categoriaRepository.findById(id);
		return findCategoria.orElseThrow( () -> new ObjectNotFoundException("ERROR: ID Objeto não encontrado no sistema") );
	}
	
	public Categoria insert(Categoria obj) {
		obj.setId(null);
		return categoriaRepository.save(obj);
	}
	
	public Categoria update(Integer id, Categoria obj) {
		Optional<Categoria> obj1 = categoriaRepository.findById(id);
		var categoria = obj1.get();
		categoria.setNome(obj.getNome());
		return categoriaRepository.save(categoria);
	}
	
	public void delete(Integer id) {
		try {
		Categoria obj = find(id);
		categoriaRepository.deleteById(obj.getId());
		} catch(org.springframework.dao.DataIntegrityViolationException e) {
			throw new DataIntegrityViolationException("ERROR: Há entidades relacionadas, não é possivel deletar.");
		}
	}
	
	public List<Categoria> findAll(){
		List<Categoria> list = categoriaRepository.findAll();
		return list;
	}
	
	
	// ============================================================================================================================
	
	public Categoria fromDto(CategoriaDTO obj) {
		return new Categoria(obj.getId(),obj.getNome());
	}
	
	public void updateData(Categoria x, Categoria y) {
		x.setId(y.getId());
		x.setNome(y.getNome());
	}
}
