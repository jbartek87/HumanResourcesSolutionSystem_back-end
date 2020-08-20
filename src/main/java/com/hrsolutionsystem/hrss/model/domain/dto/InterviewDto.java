package com.hrsolutionsystem.hrss.model.domain.dto;

import com.hrsolutionsystem.hrss.model.domain.enums.InterviewLocation;
import lombok.*;
import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class InterviewDto {
    private Long id;
    private Long recruiterId;
    private LocalDate interviewDate;
    private InterviewLocation location;
}
