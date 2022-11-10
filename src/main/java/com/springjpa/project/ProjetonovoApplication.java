package com.springjpa.project;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.springjpa.project.entities.Categoria;
import com.springjpa.project.repository.CategoriaRepository;

@SpringBootApplication
public class ProjetonovoApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(ProjetonovoApplication.class, args);
	}

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat1 = new Categoria(null, "Informatica");
		Categoria cat2 = new Categoria(null, "Escritorio"); 
		
		categoriaRepository.saveAll(Arrays.asList(cat1,cat2));
	}
}
