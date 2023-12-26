package com.talehibrahimli.tutorials.bulkemailsender;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class BulkEmailSenderApplication {

    public static void main(String[] args) {
        SpringApplication.run(BulkEmailSenderApplication.class, args);
    }

}
