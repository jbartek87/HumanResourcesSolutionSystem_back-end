package com.hrsolutionsystem.hrss.model.domain.dto;

import lombok.*;


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
}
