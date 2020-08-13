package com.hrsolutionsystem.hrss.exception.cvDetails;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class CvDetailsNotFoundAdvice {
    @ResponseBody
    @ExceptionHandler(CvDetailsNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String cvDetailsNotFoundHandler(CvDetailsNotFoundException exception) {
        return exception.getMessage();
    }
}
