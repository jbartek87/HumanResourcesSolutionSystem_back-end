package com.hrsolutionsystem.hrss.model.domain.entity;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.ControllerAdvice;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name="Recruiters")
public class Recruiters {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "RECRUITER_ID")
    private long id;

    @Column(name="LOGIN")
    @NotNull
    private String login;

    @Column(name = "PASSWORD")
    @NotNull
    private String password;

    @Column(name = "FIRST_NAME")
    @NotNull
    private String firstName;

    @Column(name = "LAST_NAME")
    @NotNull
    private String lastName;

    @Column(name = "PHONE_NUMBER")
    @NotNull
    private long phoneNumber;

    @Column(name = "email")
    @NotNull
    private String email;

    @Column(name = "COMPANIES_ID")
    @NotNull
    private long companiesId;

    @Column(name = "CV_DETAILS_ID")
    @NotNull
    private long cvDetailsId;

    @Column(name = "INTERVIEWS_ID")
    @NotNull
    private long interviewsId;

    @OneToMany(
            targetEntity = Interview.class,
            mappedBy = "recruiter",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )

    List<Interview> interviewList = new ArrayList<>();

    @OneToMany(
            targetEntity = CvDetails.class,
            mappedBy = "recruiter",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    List<CvDetails> cvDetailsList = new ArrayList<>();

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name="JOIN_RECRUITER_COMPANY",
            joinColumns = {@JoinColumn(name="COMPANIES_ID", referencedColumnName = "COMPANY_ID")},
            inverseJoinColumns = {@JoinColumn(name="RECRUITER_ID", referencedColumnName = "RECRUITER_ID")}

    )
    private List<Company> companies = new ArrayList<>();

}
