package com.talehibrahimli.tutorials.bulkemailsender.service;

import com.talehibrahimli.tutorials.bulkemailsender.config.EmailProviderConfig;
import com.talehibrahimli.tutorials.bulkemailsender.data.EmailMessageDto;
import com.talehibrahimli.tutorials.bulkemailsender.exception.EmailMessageSendingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.*;
import java.util.Properties;

@Service
@RequiredArgsConstructor
@Log4j
public class EmailMessageSenderService {

    private final EmailProviderConfig emailProviderConfig;

    public void sendEmail(EmailMessageDto emailMessageDto) throws EmailMessageSendingException {
        try {
            Properties prop = new Properties();
            prop.putAll(emailProviderConfig.getProperties());

            Session session = Session.getInstance(prop, new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(emailProviderConfig.getAuth().getUsername(), emailProviderConfig.getAuth().getPassword());
                }
            });

            Message message = new MimeMessage(session);
            message.setFrom(new

                    InternetAddress(emailMessageDto.getFrom()));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(emailMessageDto.getTo()));
            message.setSubject(emailMessageDto.getSubject());

            MimeBodyPart mimeBodyPart = new MimeBodyPart();
            mimeBodyPart.setContent(emailMessageDto.getBody(), "text/html; charset=utf-8");

            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(mimeBodyPart);

            message.setContent(multipart);

            Transport.send(message);
        } catch (MessagingException e) {
            log.error(e.getMessage(), e);
            throw new EmailMessageSendingException(e.getMessage(), e);
        }
    }
}
