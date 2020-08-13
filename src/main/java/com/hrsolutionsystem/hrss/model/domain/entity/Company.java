package com.hrsolutionsystem.hrss.model.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

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

    @Column(name = "RECRUITERS_ID", nullable = false)
    private Long recruitersId;

    @Column(name = "WANTED_EMPLOYEE_ID", nullable = false)
    private Long wantedEmployeeId;
}
