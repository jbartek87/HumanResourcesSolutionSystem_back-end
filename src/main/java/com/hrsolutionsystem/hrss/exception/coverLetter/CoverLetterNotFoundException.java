package com.hrsolutionsystem.hrss.exception.coverLetter;

public class CoverLetterNotFoundException extends RuntimeException {
    public CoverLetterNotFoundException(Long id) {
        super("Cover letter Not Found ID: " + id);
    }
}
