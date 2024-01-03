package com.talehibrahimli.tutorials.bulkemailsender.data;

import lombok.Data;

import java.util.List;

@Data
public class BulkEmailMessageDto {
    private String from;
    private List<String> to;
    private String subject;
    private String body;
}
