package com.nick.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.nick.model.EmailRequest;
import com.nick.service.EmailService;

import java.util.List;

@RestController
@RequestMapping("/api/email")
public class EmailController {
	@Autowired
	private EmailService emailService;

	@PostMapping("/send")
	public void sendEmails(@RequestBody List<EmailRequest> emailRequests) {
		for (EmailRequest emailRequest : emailRequests) {
			emailService.sendEmail(emailRequest.getTo(), emailRequest.getSubject(), emailRequest.getText());
		}
	}
}
