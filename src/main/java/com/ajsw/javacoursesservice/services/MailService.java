package com.ajsw.javacoursesservice.services;

import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;

@Service
public class MailService {
    public void sendEmail(String host, String port,
                                 final String emailUser, final String password,
                                 String subject, String message) throws AddressException,
            MessagingException, MessagingException {

        Properties properties = new Properties();// sets SMTP properties
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", port);
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.ssl.trust", host);

        Authenticator auth = new Authenticator() {// se crea una autenticación
            public PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("ciroshaila@gmail.com", "Mi password de aplicación");
            }
        };

        Session session = Session.getInstance(properties, auth);

        MimeMessage msg = new MimeMessage(session);// se crea un nuevo email
        msg.setFrom(new InternetAddress(emailUser));
        InternetAddress[] toAddresses = { new InternetAddress(emailUser) };
        msg.setRecipients(Message.RecipientType.TO, toAddresses);
        msg.setSubject(subject);
        msg.setSentDate(new Date());
        msg.setText(message);

        Transport.send(msg);// envio del email
    }
}
