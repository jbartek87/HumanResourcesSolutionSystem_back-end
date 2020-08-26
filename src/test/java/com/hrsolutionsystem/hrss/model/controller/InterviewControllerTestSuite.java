package com.hrsolutionsystem.hrss.model.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.hrsolutionsystem.hrss.jsonSerializer.LocalDateAdapter;
import com.hrsolutionsystem.hrss.model.domain.dto.InterviewDto;
import com.hrsolutionsystem.hrss.model.domain.enums.InterviewLocation;
import com.hrsolutionsystem.hrss.model.service.InterviewService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;

import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(InterviewController.class)
public class InterviewControllerTestSuite {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private InterviewService service;
    private String url = "/v1/interviews/";

    private InterviewDto dto;

    @Before
    public void init() {
        dto = new InterviewDto();
        dto.setId(1L);
        dto.setLocation(InterviewLocation.IN_OFFICE);
        dto.setInterviewDate(LocalDate.now());
        dto.setCvDetailsId(1L);
        dto.setRecruiterId(1L);

    }

    @Test
    public void saveTest() throws Exception {
        when(service.save(any())).thenReturn(dto);
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(LocalDate.class, new LocalDateAdapter().nullSafe())
                .create();

        String gsonContent = gson.toJson(dto);

        mockMvc.perform(post(url + "create")
        .contentType(MediaType.APPLICATION_JSON)
        .characterEncoding("UTF-8")
        .content(gsonContent))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.location", is(InterviewLocation.IN_OFFICE.toString())))
                .andExpect(jsonPath("$.interviewDate", is(LocalDate.now().toString())))
                .andExpect(jsonPath("$.recruiterId", is(1)))
                .andExpect(jsonPath("$.cvDetailsId", is(1)));
    }

    @Test
    public void deleteByIdTest() throws Exception {
        when(service.findById(1L)).thenReturn(dto);

        mockMvc.perform(delete(url + dto.getId()))
                .andExpect(status().isOk());
    }

    @Test
    public void findByIdTest() throws Exception {
        when(service.findById(1L)).thenReturn(dto);

        mockMvc.perform(get(url + dto.getId())
        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.location", is(InterviewLocation.IN_OFFICE.toString())))
                .andExpect(jsonPath("$.interviewDate", is(LocalDate.now().toString())))
                .andExpect(jsonPath("$.recruiterId", is(1)))
                .andExpect(jsonPath("$.cvDetailsId", is(1)));
    }
}
