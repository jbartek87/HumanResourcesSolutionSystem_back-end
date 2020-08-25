package com.hrsolutionsystem.hrss.model.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.hrsolutionsystem.hrss.model.domain.dto.RecruitersDto;
import com.hrsolutionsystem.hrss.model.domain.entity.Recruiters;
import com.hrsolutionsystem.hrss.model.service.RecruitersService;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(RecruiterController.class)
public class RecruiterControllerTestSuite {
    @Autowired
    MockMvc mockMvc;

    @MockBean
    private RecruitersService service;

    private RecruitersDto recruiter;
    private Gson gson;
    private String url = "/v1/recruiter/";

    @Before
    public void init() {
        recruiter = new RecruitersDto();
        recruiter.setId(1L);
        recruiter.setLogin("jbart");
        recruiter.setPassword("qwerty");
        recruiter.setFirstName("Kenny");
        recruiter.setLastName("Jimmy");
        recruiter.setPhoneNumber(9999L);
        recruiter.setEmail("b2b@yr.no");

        gson = new GsonBuilder().create();
    }

    @Test
    public void getByIdTest() throws Exception {
        when(service.findById(1L)).thenReturn(recruiter);

        mockMvc.perform(MockMvcRequestBuilders.get(url + recruiter.getId()).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", Matchers.is(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.login", Matchers.is("jbart")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.password", Matchers.is("qwerty")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.firstName", Matchers.is("Kenny")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.lastName", Matchers.is("Jimmy")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.phoneNumber", Matchers.is(9999)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.email", Matchers.is("b2b@yr.no")));
    }

    @Test
    public void getListTest() throws Exception {
        List<RecruitersDto> list = new ArrayList<>();
        list.add(new RecruitersDto());

        when(service.recruitersGetList()).thenReturn(list);

        mockMvc.perform(MockMvcRequestBuilders.get(url + "list").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(1)));
    }

    @Test
    public void deleteByIdTest() throws Exception {
        when(service.findById(1L)).thenReturn(recruiter);

        mockMvc.perform(MockMvcRequestBuilders.delete(url + "1").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void saveTest() throws Exception {
        when(service.save(ArgumentMatchers.any())).thenReturn(recruiter);

        String gsonContent = gson.toJson(recruiter);

        mockMvc.perform(MockMvcRequestBuilders.post(url + "create")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .content(gsonContent))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", Matchers.is(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.login", Matchers.is("jbart")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.password", Matchers.is("qwerty")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.firstName", Matchers.is("Kenny")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.lastName", Matchers.is("Jimmy")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.phoneNumber", Matchers.is(9999)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.email", Matchers.is("b2b@yr.no")));

    }

    @Test
    public void updateTest() throws Exception {
        when(service.update(ArgumentMatchers.any())).thenReturn(recruiter);

        String gsonContent = gson.toJson(recruiter);

        mockMvc.perform(MockMvcRequestBuilders.put(url + "update")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .content(gsonContent))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", Matchers.is(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.login", Matchers.is("jbart")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.password", Matchers.is("qwerty")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.firstName", Matchers.is("Kenny")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.lastName", Matchers.is("Jimmy")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.phoneNumber", Matchers.is(9999)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.email", Matchers.is("b2b@yr.no")));
    }

}