package com.hrsolutionsystem.hrss.exception.cvFile;

public class CvFileNotFoundException extends RuntimeException {
    public CvFileNotFoundException(Long id) {
        super("CV File Not Found ID: " + id);
    }
}
