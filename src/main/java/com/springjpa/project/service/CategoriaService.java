package com.springjpa.project.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springjpa.project.entities.Categoria;
import com.springjpa.project.repository.CategoriaRepository;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public Categoria find(Integer id) {
		Optional<Categoria> findCategoria = categoriaRepository.findById(id);
		return findCategoria.get();
	}
	
}
