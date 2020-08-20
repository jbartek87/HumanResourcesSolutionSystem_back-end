//package com.hrsolutionsystem.hrss.model.controller;
//
//import com.google.gson.Gson;
//import com.google.gson.GsonBuilder;
//import com.google.gson.JsonElement;
//import com.google.gson.JsonPrimitive;
//import com.hrsolutionsystem.hrss.jsonSerializer.LocalDateAdapter;
//import com.hrsolutionsystem.hrss.model.dao.WantedEmployeeDao;
//import com.hrsolutionsystem.hrss.model.domain.entity.WantedEmployee;
//import com.hrsolutionsystem.hrss.model.domain.enums.RecruitmentStatus;
//import com.hrsolutionsystem.hrss.model.domain.dto.WantedEmployeeDto;
//import com.hrsolutionsystem.hrss.model.service.WantedEmployeeService;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.ArgumentMatchers;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//
//import java.time.LocalDate;
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.hamcrest.Matchers.*;
//import static org.mockito.Mockito.when;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
//
//@RunWith(SpringRunner.class)
//@WebMvcTest(WantedEmployeeController.class)
//public class WantedEmployeeControllerTestSuite {
//    @Autowired
//    MockMvc mvc;
//
//    @MockBean
//    private WantedEmployeeService service;
//
//    private WantedEmployeeDto dto;
//    private ArrayList<String> skillSet;
//    private Gson gson;
//    private String url = "/v1/wantedEmployee/";
//
//    @Before
//    public void init() {
//        skillSet = new ArrayList<>();
//        skillSet.add("skill_1");
//        skillSet.add("skill_2");
//        skillSet.add("skill_3");
//
//        dto = new WantedEmployeeDto();
//        dto.setId(1L);
//        dto.setRecruitmentStarts(LocalDate.of(2020, 11, 8));
//        dto.setRecruitmentEnds(LocalDate.of(2020, 11, 8));
//        dto.setRequirements(skillSet);
//        dto.setStatus(RecruitmentStatus.ACTIVE);
//    }
//
//    @Before
//    public void gsonBuilder() {
//        gson = new GsonBuilder()
//                .registerTypeAdapter(LocalDate.class, new LocalDateAdapter().nullSafe())
//                .create();
//    }
//
//    @Test
//    public void getByIdTest() throws Exception {
//        when(service.wantedEmployeeFindById(1L)).thenReturn(dto);
//
//        mvc.perform(get(url + dto.getId()).contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().is(200))
//                .andExpect(jsonPath("$.requirements", is(skillSet)))
//                .andExpect(jsonPath("$.recruitmentStarts", is(dto.getRecruitmentStarts().toString())))
//                .andExpect(jsonPath("$.recruitmentEnds", is(dto.getRecruitmentEnds().toString())))
//                .andExpect(jsonPath("$.status", is("ACTIVE")));
//    }
//
//    @Test
//    public void getListTest() throws Exception {
//        List<WantedEmployeeDto> list = new ArrayList<>();
//
//        when(service.wantedEmployeeGetList()).thenReturn(list);
//
//        mvc.perform(get(url + "list").contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().is(200))
//                .andExpect(jsonPath("$", hasSize(0)));
//    }
//
//    @Test
//    public void deleteByIdTest() throws Exception {
//        when(service.wantedEmployeeFindById(1L)).thenReturn(dto);
//
//        mvc.perform(delete(url + "1").contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().is(200));
//    }
//
//    @Test
//    public void saveTest() throws Exception {
//        when(service.wantedEmployeeSave(ArgumentMatchers.any())).thenReturn(dto);
//
//        String gsonContent = gson.toJson(dto);
//
//        mvc.perform(post(url + "create")
//                .contentType(MediaType.APPLICATION_JSON)
//                .characterEncoding("UTF-8")
//                .content(gsonContent))
//                    .andExpect(status().isOk())
//                    .andExpect(jsonPath("$.recruitmentStarts", is(dto.getRecruitmentStarts().toString())))
//                    .andExpect(jsonPath("$.recruitmentEnds", is(dto.getRecruitmentEnds().toString())))
//                    .andExpect(jsonPath("$.requirements", is(skillSet)))
//                    .andExpect(jsonPath("$.status", is("ACTIVE")));
//    }
//
//    @Test
//    public void updateTest() throws Exception {
//        when(service.wantedEmployeeUpdate(ArgumentMatchers.any())).thenReturn(dto);
//        String jsonContent = gson.toJson(dto);
//
//        mvc.perform(put(url + "update")
//                .contentType(MediaType.APPLICATION_JSON)
//                .characterEncoding("UTF-8")
//                .content(jsonContent))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.recruitmentStarts", is(dto.getRecruitmentStarts().toString())))
//                .andExpect(jsonPath("$.recruitmentEnds", is(dto.getRecruitmentEnds().toString())))
//                .andExpect(jsonPath("$.requirements", is(skillSet)))
//                .andExpect(jsonPath("$.status", is("ACTIVE")));
//    }
//}
