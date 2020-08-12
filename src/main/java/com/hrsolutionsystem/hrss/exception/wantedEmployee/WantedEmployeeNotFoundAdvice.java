package com.hrsolutionsystem.hrss.exception.wantedEmployee;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class WantedEmployeeNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(WantedEmployeeNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String wantedEmployeeNotFoundHandler(WantedEmployeeNotFoundException exception) {
        return exception.getMessage();
    }
}
