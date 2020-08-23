package com.hrsolutionsystem.hrss.model.mapper;

import com.hrsolutionsystem.hrss.model.domain.enums.RecruitmentStatus;
import com.hrsolutionsystem.hrss.model.domain.entity.WantedEmployee;
import com.hrsolutionsystem.hrss.model.domain.dto.WantedEmployeeDto;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class WantedEmployeeMapperTestSuite {
    private WantedEmployeeMapper mapper = new WantedEmployeeMapperImpl();

    @Test
    public void toMapTest() {
        //Given
        ArrayList<String> skillset = new ArrayList<>();
        skillset.add("skill_1");
        skillset.add("skill_2");
        skillset.add("skill_3");

        WantedEmployeeDto dto = new WantedEmployeeDto();
        dto.setId(1L);
        dto.setRecruitmentStarts(LocalDate.now());
        dto.setRecruitmentEnds(LocalDate.now().plusDays(10));
        dto.setRequirements(skillset);
        dto.setStatus(RecruitmentStatus.ACTIVE);
        //When
        WantedEmployee map = mapper.toMap(dto);
        //Then
        assertEquals(map.getId(), dto.getId());
        assertEquals(map.getRecruitmentStarts(), dto.getRecruitmentStarts());
        assertEquals(map.getRecruitmentEnds(), dto.getRecruitmentEnds());
        assertEquals(map.getRequirements(), dto.getRequirements());
        assertEquals(map.getStatus(), dto.getStatus());
    }

    @Test
    public void toDtoTest() {
        //Given
        ArrayList<String> skillset = new ArrayList<>();
        skillset.add("skill_1");
        skillset.add("skill_2");
        skillset.add("skill_3");

        WantedEmployee map = new WantedEmployee();
        map.setId(1L);
        map.setRecruitmentStarts(LocalDate.now());
        map.setRecruitmentEnds(LocalDate.now().plusDays(10));
        map.setRequirements(skillset);
        map.setStatus(RecruitmentStatus.ACTIVE);
        //When
        WantedEmployeeDto dto = mapper.toDto(map);
        //Then
        assertEquals(dto.getId(), map.getId());
        assertEquals(dto.getRecruitmentStarts(), map.getRecruitmentStarts());
        assertEquals(dto.getRecruitmentEnds(), map.getRecruitmentEnds());
        assertEquals(dto.getRequirements(), map.getRequirements());
        assertEquals(dto.getStatus(), map.getStatus());
    }

    @Test
    public void toListTest() {
        //Given
        ArrayList<String> skillSet = new ArrayList<>();
        skillSet.add("skill_1");
        skillSet.add("skill_2");
        skillSet.add("skill_3");

        ArrayList<String> skillset2 = new ArrayList<>();
        skillset2.add("java");
        skillset2.add("jira");
        skillset2.add("git");

        WantedEmployee map = new WantedEmployee();
        map.setId(1L);
        map.setRecruitmentStarts(LocalDate.now());
        map.setRecruitmentEnds(LocalDate.now().plusDays(10));
        map.setRequirements(skillSet);
        map.setStatus(RecruitmentStatus.ACTIVE);

        WantedEmployee map2 = new WantedEmployee();
        map2.setId(2L);
        map2.setRecruitmentStarts(LocalDate.now());
        map2.setRecruitmentEnds(LocalDate.now().plusDays(10));
        map2.setRequirements(skillset2);
        map2.setStatus(RecruitmentStatus.EXPIRED);

        List<WantedEmployee> wantedEmployeeList = new ArrayList<>();
        wantedEmployeeList.add(map);
        wantedEmployeeList.add(map2);
        //When
        List<WantedEmployeeDto> wantedEmployeeDtoList = mapper.toList(wantedEmployeeList);
        Long idTest = wantedEmployeeDtoList.get(0).getId();
        LocalDate dateStart = wantedEmployeeDtoList.get(0).getRecruitmentStarts();
        LocalDate dateEnds = wantedEmployeeDtoList.get(1).getRecruitmentEnds();
//        List<String> testList = wantedEmployeeDtoList.get(1).getRequirements();
        RecruitmentStatus testStatus = wantedEmployeeDtoList.get(1).getStatus();
        System.out.println(wantedEmployeeDtoList.get(0));
        //Then
        assertEquals(map.getId(), idTest);
        assertEquals(map.getRecruitmentStarts(), dateStart);
        assertEquals(map.getRecruitmentEnds(), dateEnds);
//        assertEquals("jira", testList.get(0));
        assertEquals(RecruitmentStatus.EXPIRED, testStatus);
    }
}
