package com.hrsolutionsystem.hrss.model.domain.entity;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
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
    @Column(name = "ID")
    private Long id;

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

    @OneToMany(
            targetEntity = Interview.class,
            mappedBy = "recruiter",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<Interview> interviewList;

    @OneToMany(
            targetEntity = CvDetails.class,
            mappedBy = "recruiter",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<CvDetails> cvDetailsList;

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    private List<Company> companies;

}
