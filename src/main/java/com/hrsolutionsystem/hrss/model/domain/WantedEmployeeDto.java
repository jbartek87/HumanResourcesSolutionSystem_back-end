package com.hrsolutionsystem.hrss.model.domain;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;

@Data
@Builder
public class WantedEmployeeDto {
    private Long id;
    private ArrayList<String> requirements;
    private LocalDate recruitmentStarts;
    private LocalDate recruitmentEnds;
    private RecruitmentStatus status;
}
