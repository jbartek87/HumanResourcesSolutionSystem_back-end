package com.hrsolutionsystem.hrss.exception.cvFile.notfound;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class CvFileNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(CvFileNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String cvFileNotFoundHandler(CvFileNotFoundException exception) {
        return exception.getMessage();
    }
}
