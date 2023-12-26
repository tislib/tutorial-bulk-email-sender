package com.talehibrahimli.tutorials.bulkemailsender.service;

import com.talehibrahimli.tutorials.bulkemailsender.data.EmailMessageDto;
import com.talehibrahimli.tutorials.bulkemailsender.entity.EmailMessageEntity;
import com.talehibrahimli.tutorials.bulkemailsender.entity.EmailMessageStatus;
import com.talehibrahimli.tutorials.bulkemailsender.mapper.EmailMessageMapper;
import com.talehibrahimli.tutorials.bulkemailsender.repository.EmailMessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailMessageService {
    private final EmailMessageRepository repository;
    private final EmailMessageMapper mapper;
    private final EmailMessageSenderService emailMessageSenderService;

    public void create(EmailMessageDto emailMessageDto) {
        EmailMessageEntity entity = mapper.to(emailMessageDto);
        entity.setStatus(EmailMessageStatus.PENDING);

        repository.save(entity);
    }
}
