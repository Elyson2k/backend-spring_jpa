package com.springjpa.project;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.springjpa.project.entities.Categoria;
import com.springjpa.project.entities.Cidade;
import com.springjpa.project.entities.Estado;
import com.springjpa.project.entities.Produto;
import com.springjpa.project.repository.CategoriaRepository;
import com.springjpa.project.repository.CidadeRepository;
import com.springjpa.project.repository.EstadoRepository;
import com.springjpa.project.repository.ProdutoRepository;

@SpringBootApplication
public class ProjetonovoApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(ProjetonovoApplication.class, args);
	}

	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private ProdutoRepository produtoRepository;
	@Autowired
	private CidadeRepository cidadeRepository;
	@Autowired
	private EstadoRepository estadoRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat1 = new Categoria(null, "Informatica");
		Categoria cat2 = new Categoria(null, "Escritorio"); 
		
		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "Impressora", 800.00);
		Produto p3 = new Produto(null, "Mouse", 80.00);
		
		cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
		cat2.getProdutos().add(p2);
		
		p1.getCategorias().add(cat1);
		p2.getCategorias().addAll(Arrays.asList(cat1,cat2));
		p3.getCategorias().add(cat1);
		
		categoriaRepository.saveAll(Arrays.asList(cat1,cat2));
		produtoRepository.saveAll(Arrays.asList(p1,p2,p3));
		
		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "São Paulo");
		
		Cidade c1 = new Cidade(null, "Uberlandia", est2);
		Cidade c2 = new Cidade(null, "Sao Paulo", est1);
		Cidade c3 = new Cidade(null, "Campinas", est1);
		
		est1.getCidades().addAll(Arrays.asList(c2,c3));
		est1.getCidades().add(c1);
		
		estadoRepository.saveAll(Arrays.asList(est1,est2));
		cidadeRepository.saveAll(Arrays.asList(c1,c2,c3));
		
		
	}
}
