package com.hrsolutionsystem.hrss.model.domain;

import lombok.Data;
import org.postgresql.largeobject.LargeObject;

import java.util.Date;

@Data
public class CoverLetterDto {
    private Long id;
    private LargeObject file;
    private Date date;
}
