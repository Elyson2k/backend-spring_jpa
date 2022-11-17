package com.springjpa.project.service;

import org.springframework.mail.SimpleMailMessage;

import com.springjpa.project.entities.Pedido;

public interface EmailService {
	
	void sendOrderConfirmationEmail(Pedido obj);
	
	void sendEmail(SimpleMailMessage msg);
}
