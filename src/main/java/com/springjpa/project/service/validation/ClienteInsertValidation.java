package com.springjpa.project.service.validation;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.springjpa.project.controller.exceptions.FieldMessage;
import com.springjpa.project.dto.ClienteNewDtoPOST;
import com.springjpa.project.entities.enums.TipoCliente;
import com.springjpa.project.service.validation.utils.BR;

public class ClienteInsertValidation implements ConstraintValidator<ClienteInsert, ClienteNewDtoPOST> {
	
	
	@Override
	public void initialize(ClienteInsert ann) {
	}

	@Override
	public boolean isValid(ClienteNewDtoPOST objDto, ConstraintValidatorContext context) {
		List<FieldMessage> list = new ArrayList<>();
		
		if(objDto.getTipoCliente().equals(TipoCliente.PESSOA_FISICA.getCod())  && !BR.isValidSsn(objDto.getCpfOuCnpj())) {
			list.add(new FieldMessage("cpfOuCnpj", "CPF Invalido"));
		}
		if(objDto.getTipoCliente().equals(TipoCliente.PESSOA_JURIDICA.getCod())  && !BR.isValidTfn(objDto.getCpfOuCnpj())) {
			list.add(new FieldMessage("cpfOuCnpj", "CNPJ Invalido"));
		}
		
		
		// inclua os testes aqui, inserindo erros na lista

		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
					.addConstraintViolation();
		}
		
		return list.isEmpty();
	}
}