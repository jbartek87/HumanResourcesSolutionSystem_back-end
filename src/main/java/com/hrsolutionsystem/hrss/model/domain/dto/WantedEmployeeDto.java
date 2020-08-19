package com.hrsolutionsystem.hrss.model.domain.dto;

import com.hrsolutionsystem.hrss.model.domain.entity.WantedEmployee;
import com.hrsolutionsystem.hrss.model.domain.enums.RecruitmentStatus;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class WantedEmployeeDto {
    private Long id;
    private ArrayList<String> requirements;
    private LocalDate recruitmentStarts;
    private LocalDate recruitmentEnds;
    private RecruitmentStatus status;
    private List<CompanyDto> companyDtoList;
}
