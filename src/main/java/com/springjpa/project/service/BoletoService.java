package com.springjpa.project.service;

import java.util.Calendar;
import java.util.Date;

import org.springframework.stereotype.Service;

import com.springjpa.project.entities.PagamentoComBoleto;

@Service
public class BoletoService {
	
	public void preencherPagamentoComBoleto(PagamentoComBoleto pagto, Date instante) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(instante);
		cal.add(Calendar.DAY_OF_MONTH, 7);
		pagto.setVencimento(cal.getTime());
		
	}
	
}
