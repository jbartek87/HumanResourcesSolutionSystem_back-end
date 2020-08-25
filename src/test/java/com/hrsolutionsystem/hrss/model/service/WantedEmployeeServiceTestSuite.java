package com.hrsolutionsystem.hrss.model.service;

import com.hrsolutionsystem.hrss.exception.wantedEmployee.WantedEmployeeNotFoundException;
import com.hrsolutionsystem.hrss.model.domain.dto.CompanyDto;
import com.hrsolutionsystem.hrss.model.domain.dto.WantedEmployeeDto;
import com.hrsolutionsystem.hrss.model.domain.entity.Company;
import com.hrsolutionsystem.hrss.model.domain.enums.RecruitmentStatus;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class WantedEmployeeServiceTestSuite {
    @Autowired
    private WantedEmployeeService service;

    @Autowired
    private CompanyService companyService;

    private Long id;
    private ArrayList<String> skillSet;
    private WantedEmployeeDto dto;
    private CompanyDto companyDto;


    @Before
    public void init() {
        skillSet = new ArrayList<>();
        skillSet.add("skill_1");
        skillSet.add("skill_2");
        skillSet.add("skill_3");

        dto = new WantedEmployeeDto();
        dto.setRecruitmentStarts(LocalDate.now());
        dto.setRecruitmentEnds(LocalDate.now().plusDays(10));
        dto.setRequirements(skillSet);
        dto.setStatus(RecruitmentStatus.ACTIVE);
        companyDto = new CompanyDto();
        companyDto.setName("Coders");
        companyDto.setAddress("Woronicza 17");
        companyDto.setNip(444L);

    }

    @Test
    public void wantedEmployeeFindByIdTest() {
        //Given
        CompanyDto company = companyService.save(companyDto);
        dto.setCompanyId(company.getId());
        //When
        WantedEmployeeDto employee = service.wantedEmployeeSave(dto);
        id = Long.valueOf(employee.getId());
        //Then
        assertNotNull(service.wantedEmployeeFindById(id));
    }

    @Test
    public void wantedEmployeeListTest() {
        //Given
        CompanyDto company = companyService.save(companyDto);
        dto.setCompanyId(company.getId());
        //When
        WantedEmployeeDto employee = service.wantedEmployeeSave(dto);
        id = employee.getId();
        //Then
        List<WantedEmployeeDto> list = service.wantedEmployeeGetList();

        assertEquals(1, list.size());
    }

    @Test
    public void wantedEmployeeUpdate() {
        //Given
        CompanyDto company = companyService.save(companyDto);
        dto.setCompanyId(company.getId());
        WantedEmployeeDto employee = service.wantedEmployeeSave(dto);
        id = employee.getId();
        WantedEmployeeDto updateDto = new WantedEmployeeDto();
        updateDto.setId(id);
        updateDto.setCompanyId(company.getId());
        updateDto.setRecruitmentStarts(LocalDate.now());
        updateDto.setRecruitmentEnds(LocalDate.now().plusDays(13));
        updateDto.setRequirements(skillSet);
        updateDto.setStatus(RecruitmentStatus.EXPIRED);
        //When
        service.wantedEmployeeUpdate(updateDto);
        //Then
        assertNotEquals(service.wantedEmployeeFindById(id), dto);
    }

    @Test(expected = WantedEmployeeNotFoundException.class)
    public void notFoundExceptionTest() {
        Long testId  = 1231132323L;

        assertNull(service.wantedEmployeeFindById(testId));
    }
}
