package com.hrsolutionsystem.hrss.model.service;

import com.hrsolutionsystem.hrss.model.domain.dto.WantedEmployeeDto;
import com.hrsolutionsystem.hrss.model.domain.enums.RecruitmentStatus;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WantedEmployeeServiceTestSuite {
    @Autowired
    private WantedEmployeeService service;

    private Long id;
    private ArrayList<String> skillSet;
    private WantedEmployeeDto dto;

    @After
    public void dbCleaner() {
        service.wantedEmployeeDeleteById(id);
    }

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
    }

    @Test
    public void wantedEmployeeFindByIdTest() {
        WantedEmployeeDto employee = service.wantedEmployeeSave(dto);
        id = new Long(employee.getId());

        assertNotNull(service.wantedEmployeeFindById(id));
    }

    @Test
    public void wantedEmployeeListTest() {
        WantedEmployeeDto employee = service.wantedEmployeeSave(dto);
        id = new Long(employee.getId());

        List<WantedEmployeeDto> list = service.wantedEmployeeGetList();

        assertEquals(1, list.size());
    }

    @Test
    public void wantedEmployeeUpdate() {
        WantedEmployeeDto employee = service.wantedEmployeeSave(dto);
        id = new Long(employee.getId());

        WantedEmployeeDto updateDto = new WantedEmployeeDto();
        updateDto.setId(id);
        updateDto.setRecruitmentStarts(LocalDate.now());
        updateDto.setRecruitmentEnds(LocalDate.now().plusDays(13));
        updateDto.setRequirements(skillSet);
        updateDto.setStatus(RecruitmentStatus.EXPIRED);

        service.wantedEmployeeUpdate(updateDto);

        assertNotEquals(service.wantedEmployeeFindById(id), dto);
    }

//    @Test(expected = WantedEmployeeNotFoundException.class)
//    public void notFoundExceptionTest() {
//        Long testId  = 1231132323L;
//
//        assertNull(service.wantedEmployeeFindById(testId));
//    }
}
