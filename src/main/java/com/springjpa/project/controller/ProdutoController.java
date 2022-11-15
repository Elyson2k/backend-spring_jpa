package com.springjpa.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springjpa.project.controller.utils.URL;
import com.springjpa.project.dto.ProdutoDtoALL;
import com.springjpa.project.entities.Produto;
import com.springjpa.project.service.ProdutoService;

@RestController
@RequestMapping(value = "/api/v1/produtos")
public class ProdutoController {

	@Autowired
	private ProdutoService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<ProdutoDtoALL> find(@PathVariable Integer id){
		Produto obj = service.find(id);
		ProdutoDtoALL newObj = new ProdutoDtoALL(obj);
		return ResponseEntity.ok(newObj);
	}
	
	@SuppressWarnings("unused")
	@GetMapping
	public ResponseEntity<Page<ProdutoDtoALL>> findPage(
			@RequestParam(value="nome", defaultValue = "") String nome,
			@RequestParam(value="categorias", defaultValue = "") String categorias,
			@RequestParam(value="page", defaultValue = "0") Integer pages,
			@RequestParam(value="lines", defaultValue = "24")Integer linesPerPage,
			@RequestParam(value="order", defaultValue = "nome")String orderBy,
			@RequestParam(value="direction", defaultValue = "ASC")String direction ){
		String nomeDecod = URL.decodeParam(nome);
		List<Integer> ids = URL.decodeIntList(categorias);
		Page<Produto> list = service.search(nome , ids, pages, linesPerPage, orderBy, direction);
		Page<ProdutoDtoALL> listDto = list.map( obj -> new ProdutoDtoALL(obj));
		return ResponseEntity.ok(listDto);
	}
}
