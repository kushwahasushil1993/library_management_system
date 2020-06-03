package com.demo.librarymanagement.library_management_system.helper;

import com.demo.librarymanagement.library_management_system.model.PersonEntity;
import com.demo.librarymanagement.library_management_system.repo.ProcureBookRepo;
import org.apache.commons.collections4.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    Logger log = LoggerFactory.getLogger(EmailScheduling.class);

    @Autowired
    private ProcureBookRepo procureBookRepo;
    @Autowired
    private SendEmail email;

    @Scheduled(cron = "0 15 10 * * ?")
    @Async
    public void sendEmailAtPerticularTime(){
        Date date = new Date();
        String strDateFormat = "dd-MM-YYYY";
        DateFormat dateFormat = new SimpleDateFormat(strDateFormat);
        String formattedDate= dateFormat.format(date);
        List<PersonEntity> personEntityList = procureBookRepo.findBybookIssueDate(formattedDate);
        if (CollectionUtils.isNotEmpty(personEntityList)){
            log.info("Defaulter list", personEntityList);
            email.send(personEntityList);
        }
    }
}
