package com.hrsolutionsystem.hrss.model.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "COMPANIES")
public class Company {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private Long nip;
    private String address;
    private Recruiters recruitersId;
    private WantedEmployee wantedEmployeeId;
}
