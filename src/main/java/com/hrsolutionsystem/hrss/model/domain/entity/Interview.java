package com.hrsolutionsystem.hrss.model.domain.entity;

import com.hrsolutionsystem.hrss.model.domain.enums.InterviewLocation;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name="INTERVIEWS")
public class Interview {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "RECRUITERS_ID")
    private Long recruitersId;
    @Column(name = "CV_DETAILS_ID")
    private Long cvDetailsId;
    @Column(name = "INTERVIEW_DATE")
    private LocalDate interviewDate;
    @Column(name = "LOCATION")
    private InterviewLocation location;

    @ManyToOne
    private Recruiters recruiter;
}
