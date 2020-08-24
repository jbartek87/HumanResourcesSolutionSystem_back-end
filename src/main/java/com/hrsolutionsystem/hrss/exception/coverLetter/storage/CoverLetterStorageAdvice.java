package com.hrsolutionsystem.hrss.exception.coverLetter.storage;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class CoverLetterStorageAdvice {

    @ResponseBody
    @ExceptionHandler(CoverLetterStorageException.class)
    @ResponseStatus(HttpStatus.UNSUPPORTED_MEDIA_TYPE)
    public String coverLetterStorageExceptionHandler(CoverLetterStorageException e) {
        return e.getMessage();
    }
}
