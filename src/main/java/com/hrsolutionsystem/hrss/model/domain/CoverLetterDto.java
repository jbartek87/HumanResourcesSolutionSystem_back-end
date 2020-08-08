package com.hrsolutionsystem.hrss.model.domain;

import lombok.Data;
import java.util.Date;

@Data
public class CoverLetterDto {
    private Long id;
    private byte[] file;
    private Date date;
}
