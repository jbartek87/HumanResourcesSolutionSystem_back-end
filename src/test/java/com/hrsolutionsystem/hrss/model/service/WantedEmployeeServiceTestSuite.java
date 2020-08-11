package com.hrsolutionsystem.hrss.model.service;

import com.hrsolutionsystem.hrss.exception.wantedEmployee.WantedEmployeeNotFoundException;
import com.hrsolutionsystem.hrss.model.domain.RecruitmentStatus;
import com.hrsolutionsystem.hrss.model.domain.WantedEmployee;
import com.hrsolutionsystem.hrss.model.domain.WantedEmployeeDto;
import org.junit.After;
import org.junit.Assert;
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

    @After
    public void dbCleaner() {
        //service.wantedEmployeeDeleteById(id);
    }

    @Test
    public void wantedEmployeeFindByIdTest() {
        ArrayList<String> skillset = new ArrayList<>();
        skillset.add("skill_1");
        skillset.add("skill_2");
        skillset.add("skill_3");

//        WantedEmployeeDto dto = new WantedEmployeeDto();
//        dto.setId(6L);
//        dto.setRecruitmentStarts(LocalDate.now());
//        dto.setRecruitmentEnds(LocalDate.now().plusDays(10));
//        dto.setRequirements(skillset);
//        dto.setStatus(RecruitmentStatus.ACTIVE);

        //WantedEmployeeDto employee = service.wantedEmployeeSave(dto);
        //id = new Long(employee.getId());

        //assertNotNull(service.wantedEmployeeFindById(id));
    }

    @Test
    public void wantedEmployeeListTest() {
        ArrayList<String> skillset = new ArrayList<>();
        skillset.add("skill_1");
        skillset.add("skill_2");
        skillset.add("skill_3");

//        WantedEmployeeDto dto = new WantedEmployeeDto();
//        dto.setId(7L);
//        dto.setRecruitmentStarts(LocalDate.now());
//        dto.setRecruitmentEnds(LocalDate.now().plusDays(10));
//        dto.setRequirements(skillset);
//        dto.setStatus(RecruitmentStatus.ACTIVE);

        //WantedEmployeeDto employee = service.wantedEmployeeSave(dto);
        //id = new Long(employee.getId());

        //List<WantedEmployeeDto> list = service.wantedEmployeeGetList();

        //assertEquals(1, list.size());
    }

    @Test
    public void wantedEmployeeUpdate() {
        ArrayList<String> skillset = new ArrayList<>();
        skillset.add("skill_1");
        skillset.add("skill_2");
        skillset.add("skill_3");

//        WantedEmployeeDto dto = new WantedEmployeeDto();
//        dto.setId(7L);
//        dto.setRecruitmentStarts(LocalDate.now());
//        dto.setRecruitmentEnds(LocalDate.now().plusDays(10));
//        dto.setRequirements(skillset);
//        dto.setStatus(RecruitmentStatus.ACTIVE);

        //WantedEmployeeDto employee = service.wantedEmployeeSave(dto);
        //id = new Long(employee.getId());

//        WantedEmployeeDto updateDto = new WantedEmployeeDto();
//        updateDto.setId(id);
//        updateDto.setRecruitmentStarts(LocalDate.now());
//        updateDto.setRecruitmentEnds(LocalDate.now().plusDays(13));
//        updateDto.setRequirements(skillset);
//        updateDto.setStatus(RecruitmentStatus.EXPIRED);

        //service.wantedEmployeeUpdate(updateDto);

        //assertNotEquals(service.wantedEmployeeFindById(id), dto);
    }

    @Test
    public void wantedEmployeeCountTest() {
        ArrayList<String> skillset = new ArrayList<>();
        skillset.add("skill_1");
        skillset.add("skill_2");
        skillset.add("skill_3");

//        WantedEmployeeDto dto = new WantedEmployeeDto();
//        dto.setId(7L);
//        dto.setRecruitmentStarts(LocalDate.now());
//        dto.setRecruitmentEnds(LocalDate.now().plusDays(10));
//        dto.setRequirements(skillset);
//        dto.setStatus(RecruitmentStatus.ACTIVE);

        //WantedEmployeeDto employee = service.wantedEmployeeSave(dto);
        //id = new Long(employee.getId());

        //long count = service.wantedEmployeeCount();

        //assertEquals(count, 1L);
    }

    @Test(expected = WantedEmployeeNotFoundException.class)
    public void notFoundExceptionTest() {
        Long testId  = 1231132323235656L;

        assertNull(service.wantedEmployeeFindById(testId));
    }
}
