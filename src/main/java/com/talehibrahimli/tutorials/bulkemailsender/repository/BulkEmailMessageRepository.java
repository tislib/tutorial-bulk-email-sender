package com.talehibrahimli.tutorials.bulkemailsender.repository;

import com.talehibrahimli.tutorials.bulkemailsender.entity.BulkEmailMessageEntity;
import com.talehibrahimli.tutorials.bulkemailsender.entity.EmailMessageEntity;
import com.talehibrahimli.tutorials.bulkemailsender.entity.EmailMessageStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BulkEmailMessageRepository extends JpaRepository<BulkEmailMessageEntity, Long> {
}
