package com.talehibrahimli.tutorials.bulkemailsender.mapper;

import com.talehibrahimli.tutorials.bulkemailsender.data.BulkEmailMessageDto;
import com.talehibrahimli.tutorials.bulkemailsender.data.EmailMessageDto;
import com.talehibrahimli.tutorials.bulkemailsender.entity.BulkEmailMessageEntity;
import com.talehibrahimli.tutorials.bulkemailsender.entity.EmailMessageEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BulkEmailMessageMapper {

    BulkEmailMessageDto from(BulkEmailMessageEntity entity);

    BulkEmailMessageEntity to(BulkEmailMessageDto entity);

}
