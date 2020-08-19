package com.hrsolutionsystem.hrss.model.domain.entity;

import com.hrsolutionsystem.hrss.model.domain.enums.RecruitmentStatus;
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
public class WantedEmployee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @Lob
    @Column(name = "REQUIREMENTS")
    @NotNull
    private ArrayList<String> requirements;

    @Column(name="RECRUITMENT_STARTS")
    @NotNull
    private LocalDate recruitmentStarts;

    @Column(name = "RECRUITMENT_ENDS")
    @NotNull
    private LocalDate recruitmentEnds;

    @Column(name = "STATUS")
    @NotNull
    @Enumerated(EnumType.STRING)
    private RecruitmentStatus status;

    @ManyToOne
    @JoinColumn(name="COMPANY_ID")
    private Company company;
}
