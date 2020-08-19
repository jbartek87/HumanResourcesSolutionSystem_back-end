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
    private Long phoneNumber;

    @Column(name = "email")
    @NotNull
    private String email;

    @Column(name = "CV_DETAILS_ID")
    @NotNull
    private Long cvDetailsId;


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
    private List<Company> companies = new ArrayList<>();

}
