package com.hrsolutionsystem.hrss.model.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name="CV")
public class Cv {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ID")
    private Long id;

    @Lob
    @Column(name = "FILE", nullable = false)
    private byte[] file;

    @Column(name = "FILE_NAME", nullable = false)
    private String fileName;

    @Column(name = "DATE")
    private final LocalDate date = LocalDate.now();
}
