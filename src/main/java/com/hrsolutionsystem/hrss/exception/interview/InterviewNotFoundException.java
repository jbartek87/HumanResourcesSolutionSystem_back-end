package com.hrsolutionsystem.hrss.exception.interview;

import com.hrsolutionsystem.hrss.model.domain.entity.Interview;

public class InterviewNotFoundException extends RuntimeException {
    public InterviewNotFoundException(Long id){
        super("Interview ID: " + id + " Not Found");
    }
}
