package com.hrsolutionsystem.hrss.model.domain;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table
@Entity(name="WANTED_EMPLOYEES")
public class WantedEmployees {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "WANTED_EMPLOYEES_ID")
    private long id;

    @Lob
    @Column(name = "REQUIREMENTS")
    @NotNull
    private ArrayList<String> requirements;

    @Column(name="RECRUITMENTS_STARTS")
    @NotNull
    private LocalDate recruitmentStarts;

    @Column(name = "RECRUITMENTS_ENDS")
    @NotNull
    private LocalDate recruitmentEnds;

    @Column(name = "STATUS")
    @NotNull
    private RecruitmentStatus status;

}
