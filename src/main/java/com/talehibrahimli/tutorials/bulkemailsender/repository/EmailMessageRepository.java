package com.talehibrahimli.tutorials.bulkemailsender.repository;

import com.talehibrahimli.tutorials.bulkemailsender.entity.EmailMessageEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmailMessageRepository extends JpaRepository<EmailMessageEntity, Long> {
}
