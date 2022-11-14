package com.springjpa.project.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.springjpa.project.service.validation.ClienteInsert;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@ClienteInsert
public class ClienteNewDtoPOST implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@NotEmpty(message = "Preenchimento obrigatorio.")
	@Length(min = 4, max = 120, message = "Tamanho : Minimo 4, maximo 120 ")
	private String nome;

	@NotEmpty(message = "Preenchimento obrigatorio.")
	@Email(message = "Email esta invalido.")
	private String email;
	
	@Column(unique = true)
	@NotEmpty(message = "Preenchimento obrigatorio.")
	private String cpfOuCnpj;
	
	private Integer tipoCliente;
	
	@NotEmpty(message = "Preenchimento obrigatorio.")
	@Length(min = 4, max = 120, message = "Tamanho : Minimo 4, maximo 120 ")
	private String logradouro;
	
	@NotEmpty(message = "Preenchimento obrigatorio.")
	private String numero;
	
	private String complemento;
	
	private String bairro;
	
	private String cep;
	
	@NotEmpty(message = "Preenchimento obrigatorio.")
	private String telefone1;
	private String telefone2;
	private String telefone3;
	
	private Integer cidadeId;	
	
}
