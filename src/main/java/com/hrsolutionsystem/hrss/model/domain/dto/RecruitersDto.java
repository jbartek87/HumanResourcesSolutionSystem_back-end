package com.hrsolutionsystem.hrss.model.domain.dto;


import lombok.*;

import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class RecruitersDto {
    private Long id;
    private String login;
    private String password;
    private String firstName;
    private String lastName;
    private Long phoneNumber;
    private String email;
}
