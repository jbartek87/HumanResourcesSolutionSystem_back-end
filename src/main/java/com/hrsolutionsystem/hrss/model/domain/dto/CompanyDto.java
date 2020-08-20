package com.hrsolutionsystem.hrss.model.domain.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CompanyDto {
    private Long id;
    private String name;
    private Long nip;
    private String address;
    private List<RecruitersDto>  recruitersDtoList;
    private List<WantedEmployeeDto> wantedEmployeeDtoList;
}
