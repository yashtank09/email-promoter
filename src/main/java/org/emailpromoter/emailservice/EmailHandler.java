package org.emailpromoter.emailservice;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class EmailHandler {

    public static void sendEmail(String recipientEmail, String subject, String body) {
        final String senderEmail = "";
        final String senderPassword = "";

        Properties emailProperties = new Properties();

        emailProperties.put("mail.smtp.auth", "true");
        emailProperties.put("mail.smtp.starttls.enable", "true");
        emailProperties.put("mail.smtp.host", "smtp.gmail.com"); // Use your email provider's SMTP server
        emailProperties.put("mail.smtp.port", "587");

        Session session = Session.getInstance(emailProperties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(senderEmail, senderPassword);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(senderEmail));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recipientEmail));
            message.setSubject(subject);
            message.setText(body);
        } catch (MessagingException exception) {

        }

    }
}