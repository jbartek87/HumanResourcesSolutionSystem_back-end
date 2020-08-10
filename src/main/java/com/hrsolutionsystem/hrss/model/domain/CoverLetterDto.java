package com.hrsolutionsystem.hrss.model.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class CoverLetterDto {
    private Long id;
    private byte[] file;
    private final LocalDate date = LocalDate.now();
}
