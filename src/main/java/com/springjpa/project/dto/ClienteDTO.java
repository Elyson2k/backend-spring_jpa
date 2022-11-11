package com.springjpa.project.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.springjpa.project.entities.Cliente;
import com.springjpa.project.entities.Endereco;
import com.springjpa.project.entities.Pedido;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class ClienteDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	@NotEmpty(message = "Preenchimento obrigatorio!!")
	@Length(min = 4, max = 30, message = "O tamanho deve ser entre 4 e 30")
	private String nome;
	
	@NotEmpty(message = "Preenchimento obrigatorio!!")
	@Email(message = "Email invalido")
	private String email;
	
	private String cpfOuCnpj;
	
	private Integer tipoCliente;
	
	private List<Endereco> enderecos = new ArrayList<>();

	private Set<String> telefones = new HashSet<>();
	
	@JsonIgnore
	private List<Pedido> pedidos = new ArrayList<>();
	
	public ClienteDTO(Cliente obj) {
		id = obj.getId();
		nome = obj.getNome();
		email = obj.getEmail();
		cpfOuCnpj = obj.getCpfOuCnpj();
		tipoCliente = obj.getTipoCliente().getCod();
		enderecos = obj.getEnderecos();
		telefones = obj.getTelefones();
	}
}
