package com.fintech.loanmanager.service;

import com.fintech.loanmanager.model.Customer;
import com.fintech.loanmanager.model.Loan;
import jakarta.mail.internet.MimeMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@Service
public class EmailService {

    JavaMailSender javaMailSender;
    TemplateEngine templateEngine;

    public EmailService(JavaMailSender javaMailSender, TemplateEngine templateEngine) {
        this.javaMailSender = javaMailSender;
        this.templateEngine = templateEngine;
    }

    public void sendLoanStatusMail(Customer customer, Loan loan) {
        try {
            System.out.print("Generating meme message");
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage);
            mimeMessageHelper.setTo(customer.getEmail());
            mimeMessageHelper.setSubject("LOAN STATUS");
            mimeMessageHelper.setText("Hi "+customer.getName()+" Your loan with loan id: "+loan.getId()+" for "+loan.getLoanType()+" has been "+loan.getStatus());

            javaMailSender.send(mimeMessage);
            System.out.print("message send");
        } catch (Exception e) {
            System.out.print("failure in sending mail");
        }
    }
}
