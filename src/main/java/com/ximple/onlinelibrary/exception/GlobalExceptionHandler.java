package com.ximple.onlinelibrary.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    public MessageError handleNotFoundException(NotFoundException e) {
        return MessageError.builder().msg(e.getMessage()).build();
    }
}
