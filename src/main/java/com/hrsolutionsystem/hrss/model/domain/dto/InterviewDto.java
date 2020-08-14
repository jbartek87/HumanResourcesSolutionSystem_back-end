package com.hrsolutionsystem.hrss.model.domain.dto;

import com.hrsolutionsystem.hrss.model.domain.enums.InterviewLocation;
import lombok.*;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class InterviewDto {
    private Long id;
    private Long recruitersId;
    private Long cvDetailsId;
    private LocalDate interviewDate;
    private InterviewLocation location;
}
