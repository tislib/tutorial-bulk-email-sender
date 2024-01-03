package com.talehibrahimli.tutorials.bulkemailsender.service;

import com.talehibrahimli.tutorials.bulkemailsender.data.EmailMessageDto;
import com.talehibrahimli.tutorials.bulkemailsender.entity.EmailMessageEntity;
import com.talehibrahimli.tutorials.bulkemailsender.entity.EmailMessageStatus;
import com.talehibrahimli.tutorials.bulkemailsender.mapper.EmailMessageMapper;
import com.talehibrahimli.tutorials.bulkemailsender.repository.EmailMessageRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

@Service
@RequiredArgsConstructor
@Log4j2
public class EmailMessageKafkaScheduler {
    private final EmailMessageRepository repository;
    private final EmailMessageSenderService emailMessageSenderService;
    private final EmailMessageMapper mapper;
    private final ExecutorService executorService = Executors.newFixedThreadPool(20);
    private final Semaphore semaphoreLow = new Semaphore(30);
    private final Semaphore semaphoreMiddle = new Semaphore(100);
    private final Semaphore semaphoreHigh = new Semaphore(3000);

    // low      3X
    // middle   10X
    // high     30X

    @KafkaListener(topics = "emailMessageTopicLow", groupId = "emailMessageTopic")
    public void emailMessageTopicLow(Long messageId) throws InterruptedException {
        semaphoreLow.acquire();
        sendEmailMessage(messageId, semaphoreLow);
    }

    @KafkaListener(topics = "emailMessageTopicMedium", groupId = "emailMessageTopic")
    public void emailMessageTopicMedium(Long messageId) throws InterruptedException {
        semaphoreMiddle.acquire();
        sendEmailMessage(messageId, semaphoreMiddle);
    }

    @KafkaListener(topics = "emailMessageTopicHigh", groupId = "emailMessageTopic")
    public void emailMessageTopicHigh(Long messageId) throws InterruptedException {
        semaphoreHigh.acquire();
        sendEmailMessage(messageId, semaphoreHigh);
    }

    private void sendEmailMessage(Long messageId, Semaphore semaphore) throws InterruptedException {
        EmailMessageEntity entity = repository.findById(messageId).orElseThrow();
        EmailMessageDto dto = mapper.from(entity);
        executorService.submit(() -> { // potential problem, if task is rejected, we need to either make sure, it is not rejected or we need to release semmaphore
            try {
                emailMessageSenderService.sendEmail(dto);
                entity.setStatus(EmailMessageStatus.SENT);
            } catch (Exception e) {
                log.error(e.getMessage(), e);
                entity.setStatus(EmailMessageStatus.FAILED);
            } finally {
                repository.save(entity);
                semaphore.release();
            }
        });
    }
}
