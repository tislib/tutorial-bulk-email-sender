package com.talehibrahimli.tutorials.bulkemailsender.data;

import lombok.Data;

@Data
public class EmailMessageDto {
    private String from;
    private String to;
    private String subject;
    private String body;
}
