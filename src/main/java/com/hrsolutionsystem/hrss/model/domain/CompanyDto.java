package com.hrsolutionsystem.hrss.model.domain;

import lombok.Data;

@Data
public class CompanyDto {
    private Long id;
    private String name;
    private Long nip;
    private String address;
    private Long recruitersId;
    private Long wantedEmployeeId;
}
