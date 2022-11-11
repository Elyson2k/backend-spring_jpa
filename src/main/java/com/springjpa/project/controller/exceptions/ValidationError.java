package com.springjpa.project.controller.exceptions;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;

@Getter 
public class ValidationError extends StandardError{
	
	private List<FieldMessage> erros = new ArrayList<>();
	
	public ValidationError(Integer status, String msg, Long timeStamp) {
		super(status, msg, timeStamp);
	}	
	
	public void addError(String fieldName, String menssage) {
		erros.add(new FieldMessage(fieldName,menssage));
	}	
}
