package com.hrsolutionsystem.hrss.model.domain.dto;

import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class RecruitersDto {
    private long id;
    private String login;
    private String password;
    private String firstName;
    private String lastName;
    private long phoneNumber;
    private String email;
    private long companiesId;
    private long cvDetailsId;
    private long interviewsId;
}
