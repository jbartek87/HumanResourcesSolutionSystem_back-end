package com.hrsolutionsystem.hrss.model.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "COVER_LETTER_FILES")
public class CoverLetter {
    @Id
    @GeneratedValue
    private Long id;
    private byte[] file;
    private Date date;
}
