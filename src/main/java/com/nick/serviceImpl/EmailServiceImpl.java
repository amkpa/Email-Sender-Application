package com.nick.serviceImpl;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import com.nick.service.EmailService;

@Service
public class EmailServiceImpl implements EmailService {
    private final JavaMailSender javaMailSender;

    public EmailServiceImpl(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    @Override
    public void sendEmail(String to, String subject, String text) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(to);
            message.setSubject(subject);
            message.setText(text);

            javaMailSender.send(message);

            // Log a success message or return a success response
            System.out.println("Email sent successfully to: " + to);
            // You can also return a success response if needed
        } catch (Exception e) {
            // Handle email sending exceptions (e.g., MailSendException)
            e.printStackTrace();
            // You can log the exception or take appropriate action as needed.
            throw new RuntimeException("Failed to send email: " + e.getMessage());
        }
    }
}
