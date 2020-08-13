package com.hrsolutionsystem.hrss.model.domain.entity;

import com.sun.istack.NotNull;
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

}
