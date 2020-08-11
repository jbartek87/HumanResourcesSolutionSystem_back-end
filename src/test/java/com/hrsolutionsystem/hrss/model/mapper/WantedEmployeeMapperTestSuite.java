package com.hrsolutionsystem.hrss.model.mapper;

import com.hrsolutionsystem.hrss.model.domain.RecruitmentStatus;
import com.hrsolutionsystem.hrss.model.domain.WantedEmployee;
import com.hrsolutionsystem.hrss.model.domain.WantedEmployeeDto;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class WantedEmployeeMapperTestSuite {
    private WantedEmployeeMapper mapper = new WantedEmployeeMapperImpl();

    @Test
    public void toMapTest() {
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

        WantedEmployee map = mapper.toMap(dto);

        assertEquals(map.getId(), dto.getId());
        assertEquals(map.getRecruitmentStarts(), dto.getRecruitmentStarts());
        assertEquals(map.getRecruitmentEnds(), dto.getRecruitmentEnds());
        assertEquals(map.getRequirements(), dto.getRequirements());
        assertEquals(map.getStatus(), dto.getStatus());
    }

    @Test
    public void toDtoTest() {
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

        WantedEmployeeDto dto = mapper.toDto(map);

        assertEquals(dto.getId(), map.getId());
        assertEquals(dto.getRecruitmentStarts(), map.getRecruitmentStarts());
        assertEquals(dto.getRecruitmentEnds(), map.getRecruitmentEnds());
        assertEquals(dto.getRequirements(), map.getRequirements());
        assertEquals(dto.getStatus(), map.getStatus());
    }

    @Test
    public void toListTest() {
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

        WantedEmployee map2 = new WantedEmployee();
        map2.setId(1L);
        map2.setRecruitmentStarts(LocalDate.now());
        map2.setRecruitmentEnds(LocalDate.now().plusDays(10));
        map2.setRequirements(skillset);
        map2.setStatus(RecruitmentStatus.ACTIVE);

        List<WantedEmployee> wantedEmployeeList = new ArrayList<>();
        wantedEmployeeList.add(map);
        wantedEmployeeList.add(map2);

        List<WantedEmployeeDto> wantedEmployeeDtoList = mapper.toList(wantedEmployeeList);

        String wantedEmployeeList2 = wantedEmployeeList.toString().replace("WantedEmployee", "");
        String wantedEmployeeDtoList2 = wantedEmployeeDtoList.toString().replace("WantedEmployeeDto", "");

        assertEquals(wantedEmployeeList2, wantedEmployeeDtoList2);
    }

}
