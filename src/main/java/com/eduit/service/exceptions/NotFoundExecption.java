package com.eduit.service.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.NOT_FOUND)
public class NotFoundExecption extends RuntimeException {

    public NotFoundExecption() {
    }

    public NotFoundExecption(String message) {
        super(message);
    }

    public NotFoundExecption(String message, Throwable cause) {
        super(message, cause);
    }

    public NotFoundExecption(Throwable cause) {
        super(cause);
    }

    public NotFoundExecption(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
