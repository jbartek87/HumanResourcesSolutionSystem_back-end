package com.hrsolutionsystem.hrss.exception.wantedEmployee;

public class WantedEmployeeNotFoundException extends RuntimeException{
    public WantedEmployeeNotFoundException(Long id) {
        super("Wanted Employee Not Found ID: " + id);
    }
}
