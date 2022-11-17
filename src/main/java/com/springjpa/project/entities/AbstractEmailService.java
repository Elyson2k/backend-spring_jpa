package com.springjpa.project.entities;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;

import com.springjpa.project.service.EmailService;

public abstract class AbstractEmailService implements EmailService{
	
	@Value("${default.sender}")
	private String sender;

	// Enviando o email.
	@Override
	public void sendOrderConfirmationEmail(Pedido obj) {
		// Campo que chama a função que prepara o SimpleMailMessaage e recebe um SimpleMailMessage.
		SimpleMailMessage sm = prepareSimpleMailMessageFromPedido(obj);
		// Campo que envia o email.
		sendEmail(sm);
	}

	// Preparando o SimpleMailMessage.
	protected SimpleMailMessage prepareSimpleMailMessageFromPedido(Pedido obj) {
		SimpleMailMessage sm = new SimpleMailMessage();
		
		// Campo informando para quem irei enviar o email.
		sm.setTo(obj.getCliente().getEmail());
		// Campo informando quem enviou o email.
		sm.setFrom(sender);
		// Campo informando o assunto do email.
		sm.setSubject("Pedido confirmado! Código " + obj.getId());
		// Campo informando a data do email.
		sm.setSentDate(new Date(System.currentTimeMillis()));
		// Campo para imprimir o que é o pedido.
		sm.setText(obj.toString());
		
		return sm;
	}

}
