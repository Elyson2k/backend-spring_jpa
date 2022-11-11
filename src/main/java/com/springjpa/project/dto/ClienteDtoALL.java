package com.springjpa.project.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.springjpa.project.entities.Cliente;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class ClienteDtoALL implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	@NotEmpty(message = "Preenchimento obrigatorio!!")
	@Length(min = 4, max = 30, message = "O tamanho deve ser entre 4 e 30")
	private String nome;
	
	@NotEmpty(message = "Preenchimento obrigatorio!!")
	@Email(message = "Email invalido")
	private String email;
	
	public ClienteDtoALL(Cliente obj) {
		id = obj.getId();
		nome = obj.getNome();
		email = obj.getEmail();
	}
}
