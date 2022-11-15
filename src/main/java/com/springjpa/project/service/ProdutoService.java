package com.springjpa.project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.springjpa.project.dto.ProdutoDtoALL;
import com.springjpa.project.entities.Categoria;
import com.springjpa.project.entities.Produto;
import com.springjpa.project.repository.CategoriaRepository;
import com.springjpa.project.repository.ProdutoRepository;
import com.springjpa.project.service.exceptions.ObjectNotFoundException;

@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository repository;

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public Produto find(Integer id) {
		Optional<Produto> obj = repository.findById(id);
		return obj.orElseThrow( () -> new ObjectNotFoundException("ERROR: ID não encontrado no sistema") );
	}
	
	public Page<Produto> search(String nome, List<Integer> ids, Integer pages, Integer linesPerPage, String orderBy, String direction){
		PageRequest pageR = PageRequest.of(pages, linesPerPage, Direction.valueOf(direction), orderBy);
		List<Categoria> categorias = categoriaRepository.findAllById(ids);
		
		return repository.findDistinctByNomeContainingAndCategoriasIn(nome, categorias, pageR);
	}
	
	// ============================================================================================================================
	
	//                                                     FUNÇÕES / METODOS
			
	// ============================================================================================================================
	
	public Produto fromDto(ProdutoDtoALL obj) {
		return new Produto(obj.getId(), obj.getNome(), obj.getPreco());
	}
	
}
