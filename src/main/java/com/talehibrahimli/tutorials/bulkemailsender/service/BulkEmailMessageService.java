package com.talehibrahimli.tutorials.bulkemailsender.service;

import com.talehibrahimli.tutorials.bulkemailsender.data.BulkEmailMessageDto;
import com.talehibrahimli.tutorials.bulkemailsender.data.EmailMessageDto;
import com.talehibrahimli.tutorials.bulkemailsender.entity.BulkEmailMessageEntity;
import com.talehibrahimli.tutorials.bulkemailsender.mapper.BulkEmailMessageMapper;
import com.talehibrahimli.tutorials.bulkemailsender.repository.BulkEmailMessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BulkEmailMessageService {
    private final BulkEmailMessageRepository repository;
    private final BulkEmailMessageMapper mapper;
    private final EmailMessageService emailMessageService;

    public void create(BulkEmailMessageDto bulkEmailMessageDto) {
        BulkEmailMessageEntity entity = mapper.to(bulkEmailMessageDto);

        repository.save(entity);

        for (String to : bulkEmailMessageDto.getTo()) {
            EmailMessageDto emailMessageDto = new EmailMessageDto();
            emailMessageDto.setFrom(bulkEmailMessageDto.getFrom());
            emailMessageDto.setTo(to);
            emailMessageDto.setSubject(bulkEmailMessageDto.getSubject());
            emailMessageDto.setBody(bulkEmailMessageDto.getBody());

            emailMessageService.create(emailMessageDto);
        }
    }
}
