package com.springjpa.project.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.springjpa.project.dto.CategoriaDTO;
import com.springjpa.project.entities.Categoria;
import com.springjpa.project.service.CategoriaService;

@RestController
@RequestMapping(value = "api/v1/categorias")
public class CategoriaResource {
	
	@Autowired
	private CategoriaService categoriaSerivce;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Categoria> findId(@PathVariable Integer id){
		Categoria obj = categoriaSerivce.find(id);
		return ResponseEntity.status(HttpStatus.OK).body(obj);
	}
	
	@PostMapping
	public ResponseEntity<Void> insert(@RequestBody CategoriaDTO obj){
		Categoria x = categoriaSerivce.fromDto(obj);
		x = categoriaSerivce.insert(x);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();		
	} 
	
}
