package com.talehibrahimli.tutorials.bulkemailsender.data;

import com.talehibrahimli.tutorials.bulkemailsender.entity.EmailMessagePriority;
import lombok.Data;

import java.util.List;

@Data
public class BulkEmailMessageDto {
    private String from;
    private List<String> to;
    private String subject;
    private String body;
    private EmailMessagePriority priority;
}
