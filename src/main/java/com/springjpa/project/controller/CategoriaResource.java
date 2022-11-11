package com.springjpa.project.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.springjpa.project.dto.CategoriaDTO;
import com.springjpa.project.dto.CategoriaDtoALL;
import com.springjpa.project.entities.Categoria;
import com.springjpa.project.service.CategoriaService;

@RestController
@RequestMapping(value = "api/v1/categorias")
public class CategoriaResource {
	
	@Autowired
	private CategoriaService categoriaSerivce;
	
	@GetMapping
	public ResponseEntity<List<CategoriaDtoALL>> findAll(){
		List<Categoria> list = categoriaSerivce.findAll();
		List<CategoriaDtoALL> listDto = list.stream().map( obj -> new CategoriaDtoALL(obj)).toList();
		return ResponseEntity.ok(listDto);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<CategoriaDTO> findId(@PathVariable Integer id){
		Categoria obj = categoriaSerivce.find(id);
		CategoriaDTO newObj = new CategoriaDTO(obj);
		return ResponseEntity.status(HttpStatus.OK).body(newObj);
	}
	
	@PostMapping
	public ResponseEntity<Void> insert(@RequestBody CategoriaDTO obj){
		Categoria x = categoriaSerivce.fromDto(obj);
		x = categoriaSerivce.insert(x);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();		
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Void> update(@PathVariable Integer id, @RequestBody CategoriaDTO obj){
		Categoria newObj = categoriaSerivce.fromDto(obj);
		newObj = categoriaSerivce.update(id,newObj);
		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		categoriaSerivce.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	
}
