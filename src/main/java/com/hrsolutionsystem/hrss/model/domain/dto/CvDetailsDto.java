package com.hrsolutionsystem.hrss.model.domain.dto;

import com.hrsolutionsystem.hrss.model.domain.enums.CvStatus;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class CvDetailsDto {
    private Long id;
    private String applyingPosition;
    private String firstName;
    private String lastName;
    private Long phoneNumber;
    private String email;
    private Long recruiterId;
    private String cvFileId;
    private String coverLetterId;
    private CvStatus status;
}
