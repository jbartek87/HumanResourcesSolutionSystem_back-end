package com.hrsolutionsystem.hrss.exception.cvDetails;

public class CvDetailsNotFoundException extends RuntimeException{
    public CvDetailsNotFoundException(Long id) {
        super("CV Details Not Found ID: " + id);
    }
}
