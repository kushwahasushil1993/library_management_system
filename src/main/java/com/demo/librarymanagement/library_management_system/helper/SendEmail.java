package com.demo.librarymanagement.library_management_system.helper;

import com.demo.librarymanagement.library_management_system.model.PersonEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import java.util.List;

@Service
public class SendEmail {

    @Autowired
    public JavaMailSender emailSender;

    /*@Autowired
    private SimpleMailMessage simpleMailMessage;*/

    public void send(List<PersonEntity> personEntityList) {
        personEntityList.stream().forEach(personEntity -> {
            String msg = "Hi " + personEntity.getFirstName() + "<br></br> Issued Date for book " + personEntity.getBookIssueDate() +
                    " and return date is"+ personEntity.getBookReturnDate() +" exceed kindly please return the book as soon as possible "
                    +"<br></br>" + "Thanks & Regards <br></br> Sushil K Kushwaha <br></br> Library Admin";
            try {
                SimpleMailMessage message = new SimpleMailMessage();
                message.setTo(personEntity.getEmail());
                message.setSubject("Book Issued Date Expire");
                message.setText(msg);

                emailSender.send(message);
            } catch (MailException exception) {
                exception.printStackTrace();
            }
        });
    }
}
