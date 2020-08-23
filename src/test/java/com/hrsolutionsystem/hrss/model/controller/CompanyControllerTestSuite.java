package com.hrsolutionsystem.hrss.model.controller;

import com.google.gson.Gson;
import com.hrsolutionsystem.hrss.model.domain.dto.CompanyDto;
import com.hrsolutionsystem.hrss.model.service.CompanyService;
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

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(CompanyController.class)
public class CompanyControllerTestSuite {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    private CompanyService service;

    CompanyDto companyDto;
    private String url = "/v1/company/";

    @Before
    public void init() {
        companyDto = new CompanyDto();
        companyDto.setId(1L);
        companyDto.setName("Google");
        companyDto.setAddress("New York");
        companyDto.setNip(12345L);
    }

    @Test
    public void findCompanyByIdTest() throws Exception {
        when(service.findById(1L)).thenReturn(companyDto);

        mockMvc.perform(MockMvcRequestBuilders.get(url + companyDto.getId()).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", Matchers.is(1)))
                .andExpect(jsonPath("$.name", Matchers.is("Google")))
                .andExpect(jsonPath("$.address", Matchers.is("New York")))
                .andExpect(jsonPath("$.nip", Matchers.is(12345)));

    }

    @Test
    public void deleteCompanyByIdTest() throws Exception {
        when(service.findById(1L)).thenReturn(companyDto);
        mockMvc.perform(MockMvcRequestBuilders.delete(url + companyDto.getId()).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void saveCompanyTest() throws Exception {
        when(service.save(ArgumentMatchers.any())).thenReturn(companyDto);
        Gson gson = new Gson();
        String jsonContent = gson.toJson(companyDto);
        mockMvc.perform(MockMvcRequestBuilders.post(url + "create")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .content(jsonContent))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", Matchers.is(1)))
                .andExpect(jsonPath("$.name", Matchers.is("Google")))
                .andExpect(jsonPath("$.address", Matchers.is("New York")))
                .andExpect(jsonPath("$.nip", Matchers.is(12345)));
    }

}