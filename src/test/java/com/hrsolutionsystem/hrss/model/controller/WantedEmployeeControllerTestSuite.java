package com.hrsolutionsystem.hrss.model.controller;

import com.google.gson.Gson;
import com.hrsolutionsystem.hrss.model.domain.RecruitmentStatus;
import com.hrsolutionsystem.hrss.model.domain.WantedEmployeeDto;
import com.hrsolutionsystem.hrss.model.service.WantedEmployeeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(WantedEmployeeController.class)
public class WantedEmployeeControllerTestSuite {
    @Autowired
    private MockMvc mvc;

    @MockBean
    private WantedEmployeeService service;

    private String url = "/v1/wantedEmployee";

    @Test
    public void getByIdTest() throws Exception{
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

        when(service.wantedEmployeeFindById(1L)).thenReturn(dto);

        mvc.perform(get(url + "/1").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is(200))
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.requirements", is(skillset)))
                .andExpect(jsonPath("$.recruitmentStarts", is(LocalDate.now())))
                .andExpect(jsonPath("$.recruitmentEnds", is(LocalDate.now().plusDays(10))))
                .andExpect(jsonPath("$.status", is(RecruitmentStatus.ACTIVE)));
    }

    @Test
    public void getListTest() throws Exception {
        List<WantedEmployeeDto> list = new ArrayList<>();

        when(service.wantedEmployeeGetList()).thenReturn(list);

        mvc.perform(get(url + "/list").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is(200))
                .andExpect(jsonPath("$", hasSize(0)));
    }

    @Test
    public void deleteByIdTest() throws Exception {
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

        when(service.wantedEmployeeFindById(1L)).thenReturn(dto);

        mvc.perform(delete(url + "/1").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is(200));
    }

    @Test
    public void saveTest() throws Exception {
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

        when(service.wantedEmployeeSave(dto)).thenReturn(dto);

        mvc.perform(post(url + "/create").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is(200))
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.requirements", is(skillset)))
                .andExpect(jsonPath("$.recruitmentStarts", is(LocalDate.now())))
                .andExpect(jsonPath("$.recruitmentEnds", is(LocalDate.now().plusDays(10))))
                .andExpect(jsonPath("$.status", is(RecruitmentStatus.ACTIVE)));

    }

    @Test
    public void updateTest() throws Exception {
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

        when(service.wantedEmployeeUpdate(ArgumentMatchers.any())).thenReturn(dto);
        Gson gson = new Gson();
        String jsonContent = gson.toJson(dto);

        mvc.perform(put(url + "/update").contentType(MediaType.APPLICATION_JSON)
            .characterEncoding("UTF-8")
            .content(jsonContent))
                .andExpect(status().is(200))
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.requirements", is(skillset)))
                .andExpect(jsonPath("$.recruitmentStarts", is(LocalDate.now())))
                .andExpect(jsonPath("$.recruitmentEnds", is(LocalDate.now().plusDays(10))))
                .andExpect(jsonPath("$.status", is(RecruitmentStatus.ACTIVE)));
    }
}
