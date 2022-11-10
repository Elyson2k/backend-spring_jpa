package com.springjpa.project.entities.enums;

import lombok.Getter;

@Getter
public enum TipoCliente {
	
	PESSOA_FISICA(1,"Pessoa Fisica"),
	PESSOA_JURIDICA(2, "Pessoa Juridica");
	
	private int cod;
	private String descricao;
	private TipoCliente(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}
	
	public static TipoCliente toEnum(Integer cod) {
		for(TipoCliente x : TipoCliente.values()) {
			if(cod.equals(x)) return x;
		}
		return null;
	}
	
}
