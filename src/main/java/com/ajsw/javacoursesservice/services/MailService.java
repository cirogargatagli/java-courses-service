package com.ajsw.javacoursesservice.services;

import com.ajsw.javacoursesservice.models.entities.Reserve;
import com.ajsw.javacoursesservice.util.MailUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailService {

    private JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String fromMessage;
    private MailUtil mailUtil;

    static final String SUBJECT = "Reserve created successfully";

    @Autowired
    public MailService(JavaMailSender javaMailSender, MailUtil mailUtil){
        this.javaMailSender = javaMailSender;
        this.mailUtil = mailUtil;
    }

    public String sendEmail(String emailTo, Reserve reserve){

        try {
            SimpleMailMessage message = new SimpleMailMessage();

            message.setFrom(fromMessage);
            message.setTo(emailTo);
            message.setSubject(SUBJECT);
            message.setText(mailUtil.createTextMessage(reserve));

            javaMailSender.send(message);

            return "Mail Sent Successfully";
        } catch (Exception e){
            return "Error while Sending Mail";
        }
    }
}
