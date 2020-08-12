package com.hrsolutionsystem.hrss.model.domain.dto;

import com.hrsolutionsystem.hrss.model.domain.enums.CvStatus;
import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class CvDetailsDto {
    private long id;
    private String applyingPosition;
    private String firstName;
    private String lastName;
    private long phoneNumber;
    private String email;
    private long cvFileId;
    private long coverLetterId;
    private CvStatus status;
}
