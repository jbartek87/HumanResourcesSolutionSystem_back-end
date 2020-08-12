package com.hrsolutionsystem.hrss.model.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name="Recruiters")
public class Recruiters {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name="LOGIN")
    private String login;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "PHONE_NUMBER")
    private long phoneNumber;

    @Column(name = "email")
    private String email;

    @Column(name = "COMPANIES_ID")
    private long companiesId;

    @Column(name = "CV_DETAILS_ID")
    private long cvDetailsId;

    @Column(name = "INTERVIEWS_ID")
    private long interviewsId;

}
