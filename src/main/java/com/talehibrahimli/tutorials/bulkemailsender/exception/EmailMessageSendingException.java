package com.talehibrahimli.tutorials.bulkemailsender.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Email message sending failed")
public class EmailMessageSendingException extends RuntimeException {
    public EmailMessageSendingException() {
    }

    public EmailMessageSendingException(String message) {
        super(message);
    }

    public EmailMessageSendingException(String message, Throwable cause) {
        super(message, cause);
    }

    public EmailMessageSendingException(Throwable cause) {
        super(cause);
    }

    public EmailMessageSendingException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

