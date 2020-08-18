package com.hrsolutionsystem.hrss.exception.company;

public class CompanyNotFoundException extends RuntimeException{
    public CompanyNotFoundException(Long id) {
        super("NOT FOUND Company with ID: " + id);
    }
}
