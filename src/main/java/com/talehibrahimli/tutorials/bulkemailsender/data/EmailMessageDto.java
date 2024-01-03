package com.talehibrahimli.tutorials.bulkemailsender.data;

import com.talehibrahimli.tutorials.bulkemailsender.entity.EmailMessagePriority;
import lombok.Data;

@Data
public class EmailMessageDto {
    private String from;
    private String to;
    private String subject;
    private String body;
    private EmailMessagePriority priority;
}
