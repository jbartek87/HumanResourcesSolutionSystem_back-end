package com.hrsolutionsystem.hrss.exception.recruiter;

public class RecruitersNotFoundException extends RuntimeException{
    public RecruitersNotFoundException(Long id){
        super("Recruiter ID:" + id + " Not Found");
    }
}
