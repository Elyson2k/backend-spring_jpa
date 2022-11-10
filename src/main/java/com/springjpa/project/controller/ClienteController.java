package com.springjpa.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springjpa.project.entities.Cliente;
import com.springjpa.project.service.ClienteService;

@RestController
@RequestMapping(value = "api/v1/clientes")
public class ClienteController {

	@Autowired
	private ClienteService cliService;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Cliente> find(@PathVariable Integer id){
		Cliente obj = cliService.find(id);
		return ResponseEntity.ok(obj);
	}
}
