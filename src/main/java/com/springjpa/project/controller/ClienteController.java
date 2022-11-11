package com.springjpa.project.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springjpa.project.dto.ClienteDTO;
import com.springjpa.project.entities.Cliente;
import com.springjpa.project.service.ClienteService;

@RestController
@RequestMapping(value = "api/v1/clientes")
public class ClienteController {

	@Autowired
	private ClienteService cliService;
	
	@GetMapping
	public ResponseEntity<List<ClienteDTO>> findAll(){
		List<Cliente> obj = cliService.findAll();
		List<ClienteDTO> newObj = obj.stream().map(obj1 -> new ClienteDTO(obj1)).toList();
		return ResponseEntity.ok(newObj);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<ClienteDTO> find(@PathVariable Integer id){
		Cliente obj = cliService.find(id);
		ClienteDTO newObj = new ClienteDTO(obj);
		return ResponseEntity.ok(newObj);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Void> update(@PathVariable Integer id, @Valid @RequestBody ClienteDTO clienteDto){
		Cliente obj = cliService.fromDto(clienteDto);
		obj = cliService.update(id, obj);
		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		cliService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping(value = "/page")
	public ResponseEntity<Page<ClienteDTO>> findPage(
			@RequestParam(value="page", defaultValue = "0") Integer pages,
			@RequestParam(value="lines", defaultValue = "24")Integer linesPerPage,
			@RequestParam(value="order", defaultValue = "nome")String orderBy,
			@RequestParam(value="direction", defaultValue = "ASC")String direction ){
		Page<Cliente> list = cliService.findPage(pages, linesPerPage, orderBy, direction);
		Page<ClienteDTO> listDto = list.map( obj -> new ClienteDTO(obj));
		return ResponseEntity.ok(listDto);
	}
	
}
