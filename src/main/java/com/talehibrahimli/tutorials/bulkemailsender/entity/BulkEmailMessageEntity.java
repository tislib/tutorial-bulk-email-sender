package com.talehibrahimli.tutorials.bulkemailsender.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class BulkEmailMessageEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(name = "\"from\"")
    private String from;

    @ElementCollection(targetClass = String.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "\"to\"", joinColumns = @JoinColumn(name = "bulk_email_message_id"))
    @Column(name = "\"to\"")
    private List<String> to;

    private String subject;

    @Column(columnDefinition = "TEXT")
    private String body;
}
