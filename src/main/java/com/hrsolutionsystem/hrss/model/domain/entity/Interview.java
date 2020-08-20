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

    @Column(name = "INTERVIEW_DATE")
    private LocalDate interviewDate;

    @Column(name = "LOCATION")
    @Enumerated(EnumType.STRING)
    private InterviewLocation location;

    @ManyToOne
    @JoinColumn(name="RECRUITER_ID")
    private Recruiters recruiter;
}
