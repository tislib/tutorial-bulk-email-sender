package com.talehibrahimli.tutorials.bulkemailsender.mapper;

import com.talehibrahimli.tutorials.bulkemailsender.data.EmailMessageDto;
import com.talehibrahimli.tutorials.bulkemailsender.entity.EmailMessageEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EmailMessageMapper {

    EmailMessageDto from(EmailMessageEntity entity);

    EmailMessageEntity to(EmailMessageDto entity);

}
