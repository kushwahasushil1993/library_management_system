package com.demo.librarymanagement.library_management_system.helper;

import com.demo.librarymanagement.library_management_system.model.PersonEntity;
import com.demo.librarymanagement.library_management_system.repo.ProcureBookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Component
public class EmailScheduling {

    @Autowired
    private ProcureBookRepo procureBookRepo;
    @Autowired
    private SendEmail email;

    @Scheduled(fixedRate = 500)
    @Async
    public void sendEmailAtPerticularTime(){
        Date date = new Date();
        String strDateFormat = "dd-MM-YYYY";
        DateFormat dateFormat = new SimpleDateFormat(strDateFormat);
        String formattedDate= dateFormat.format(date);
        List<PersonEntity> personEntityList = procureBookRepo.findBybookIssueDate(formattedDate);
        email.send(personEntityList);
    }
}
