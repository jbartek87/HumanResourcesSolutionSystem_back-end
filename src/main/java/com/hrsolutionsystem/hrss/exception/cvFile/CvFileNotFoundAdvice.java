package com.hrsolutionsystem.hrss.exception.cvFile;

import com.hrsolutionsystem.hrss.exception.cvDetails.CvDetailsNotFoundException;
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
    public String cvFileNotFoundHandler(CvDetailsNotFoundException exception) {
        return exception.getMessage();
    }
}
