package com.hrsolutionsystem.hrss.exception.wantedEmployee;

public class RecruitersNotFoundException extends RuntimeException{
    public RecruitersNotFoundException(Long id){
        super("Recruiter ID:" + id + " Not Found");
    }
}
