package com.springjpa.project;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.springjpa.project.entities.Categoria;
import com.springjpa.project.entities.Cidade;
import com.springjpa.project.entities.Cliente;
import com.springjpa.project.entities.Endereco;
import com.springjpa.project.entities.Estado;
import com.springjpa.project.entities.Pagamento;
import com.springjpa.project.entities.PagamentoComBoleto;
import com.springjpa.project.entities.PagamentoComCartao;
import com.springjpa.project.entities.Pedido;
import com.springjpa.project.entities.Produto;
import com.springjpa.project.entities.enums.EstadoPagamento;
import com.springjpa.project.entities.enums.TipoCliente;
import com.springjpa.project.repository.CategoriaRepository;
import com.springjpa.project.repository.CidadeRepository;
import com.springjpa.project.repository.ClienteRepository;
import com.springjpa.project.repository.EnderecoRepository;
import com.springjpa.project.repository.EstadoRepository;
import com.springjpa.project.repository.PagamentoRepository;
import com.springjpa.project.repository.PedidoRepository;
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
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private EnderecoRepository enderecoRepository;
	@Autowired
	private PedidoRepository pedidoRepository;
	@Autowired
	private PagamentoRepository pagamentoRepository;
	
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
		
		Cliente cli1 = new Cliente(null, "Maria", "maria@gmail.com", "36378912377", TipoCliente.PESSOA_FISICA);
		cli1.getTelefones().addAll(Arrays.asList("99999-0000", "99999-1111"));
		
		Endereco e1 = new Endereco(null, "Rua Flores", "300", "Apto 303", "Jardin", "38220832", cli1, c1);
		Endereco e2 = new Endereco(null, "Rua Avenida Medeiros", "105", "Sala 800", "Centro", "6260832", cli1, c2);
		
		cli1.getEnderecos().addAll(Arrays.asList(e1,e2));
		
		clienteRepository.saveAll(Arrays.asList(cli1));
		enderecoRepository.saveAll(Arrays.asList(e1,e2));
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:ss");
		
		Pedido ped1 = new Pedido(null, sdf.parse("30/09/2017 10:32"), cli1, e1);
		Pedido ped2 = new Pedido(null, sdf.parse("10/10/2017 19:35"), cli1, e2);
		
		Pagamento pagto1 = new PagamentoComCartao(null, EstadoPagamento.QUITADO, ped1, 6);
		ped1.setPagamento(pagto1);
		Pagamento pagto2 = new PagamentoComBoleto(null, EstadoPagamento.PENDENTE, ped2, sdf.parse("20/10/2017 00:00") , null);
		ped2.setPagamento(pagto2);
		
		cli1.getPedidos().addAll(Arrays.asList(ped1,ped2));
		
		pedidoRepository.saveAll(Arrays.asList(ped1,ped2));
		pagamentoRepository.saveAll(Arrays.asList(pagto1,pagto2));
		
	}
}
