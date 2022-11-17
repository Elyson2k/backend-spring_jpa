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
import com.springjpa.project.entities.ItemPedido;
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
import com.springjpa.project.repository.ItemPedidoRepository;
import com.springjpa.project.repository.PagamentoRepository;
import com.springjpa.project.repository.PedidoRepository;
import com.springjpa.project.repository.ProdutoRepository;

@SpringBootApplication
public class ProjetonovoApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(ProjetonovoApplication.class, args);
	}

	
	
	
	@Override
	public void run(String... args) throws Exception {
		
		
		
	}
}
