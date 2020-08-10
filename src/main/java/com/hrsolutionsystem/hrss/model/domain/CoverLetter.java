package com.hrsolutionsystem.hrss.model.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "COVER_LETTER_FILES")
public class CoverLetter {
    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Long id;

    @Lob
    @Column(name = "FILE", nullable = false)
    private byte[] file;

    @Column(name = "FILE_NAME", nullable = false)
    private String fileName;

    @Column(name = "FILE_TYPE", nullable = false)
    private String fileType;

    @Column(name = "DATE")
    private final LocalDate date = LocalDate.now();
}
