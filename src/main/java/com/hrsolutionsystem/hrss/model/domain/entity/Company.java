package com.hrsolutionsystem.hrss.model.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "COMPANIES")
public class Company {
    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "NIP", nullable = false)
    private Long nip;

    @Column(name = "ADDRESS", nullable = false)
    private String address;


    @OneToMany(
            targetEntity = WantedEmployee.class,
            mappedBy = "company",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<WantedEmployee> wantedEmployeeList;

    @ManyToMany(
            cascade = CascadeType.ALL,
            mappedBy = "companies"
    )
    private List<Recruiters> recruiters;
}
