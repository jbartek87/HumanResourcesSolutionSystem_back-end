package com.hrsolutionsystem.hrss.model.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.postgresql.largeobject.LargeObject;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
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
    private LargeObject file;
    private Date date;
}
