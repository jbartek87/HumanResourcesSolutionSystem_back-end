package com.hrsolutionsystem.hrss.exception.interview;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class InterviewNotFoundAdvice {
    @ResponseBody
    @ExceptionHandler(InterviewNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String interviewNotFoundHandler(InterviewNotFoundException exception){
       return exception.getMessage();
    }
}
