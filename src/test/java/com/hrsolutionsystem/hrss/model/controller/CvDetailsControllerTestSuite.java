package com.hrsolutionsystem.hrss.model.controller;

import com.google.gson.Gson;
import com.hrsolutionsystem.hrss.model.domain.dto.CvDetailsDto;
import com.hrsolutionsystem.hrss.model.domain.enums.CvStatus;
import com.hrsolutionsystem.hrss.model.service.CvDetailsService;
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

import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(CvDetailsController.class)
public class CvDetailsControllerTestSuite {
    @Autowired
    MockMvc mockMvc;

    @MockBean
    private CvDetailsService service;

    private CvDetailsDto dto;
    private String url = "/v1/cvDetails/";
    private final static String CV_FILE_ID = "5044a5d4-b225-40e9-b93a-17f2b0a54fb1";
    private final static String COVER_LETTER_FILE_ID = "a45cc045-3185-466e-9d91-a91329060820";

    @Before
    public void init() {
        dto = new CvDetailsDto();
        dto.setId(1L);
        dto.setApplyingPosition("Junior Developer Life Matters");
        dto.setCoverLetterId(COVER_LETTER_FILE_ID);
        dto.setCvFileId(CV_FILE_ID);
        dto.setEmail("kokoszka@o2.pl");
        dto.setFirstName("Kokosza");
        dto.setLastName("Pojoak");
        dto.setPhoneNumber(123123123L);
        dto.setStatus(CvStatus.HIRED);
    }

    @Test
    public void findCvDetailsByIdTest() throws Exception {
        when(service.findById(1L)).thenReturn(dto);

        mockMvc.perform(get(url + dto.getId()).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.applyingPosition", is("Junior Developer Life Matters")))
                .andExpect(jsonPath("$.firstName", is("Kokosza")))
                .andExpect(jsonPath("$.lastName", is("Pojoak")))
                .andExpect(jsonPath("$.phoneNumber", is(Integer.parseInt(dto.getPhoneNumber().toString()))))
                .andExpect(jsonPath("$.email", is("kokoszka@o2.pl")))
                .andExpect(jsonPath("$.cvFileId", is(CV_FILE_ID)))
                .andExpect(jsonPath("$.coverLetterId", is(COVER_LETTER_FILE_ID)))
                .andExpect(jsonPath("$.status", is("HIRED")));
    }

    @Test
    public void deleteCvDetailsByIdTest() throws Exception {
        when(service.findById(1L)).thenReturn(dto);

        mockMvc.perform(delete(url + dto.getId()).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void createCvDetailsTest() throws Exception {
        when(service.save(ArgumentMatchers.any())).thenReturn(dto);

        Gson gson = new Gson();
        String jsonContent = gson.toJson(dto);

        mockMvc.perform(post(url + "create")
        .contentType(MediaType.APPLICATION_JSON)
        .characterEncoding("UTF-8")
        .content(jsonContent))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.applyingPosition", is("Junior Developer Life Matters")))
                .andExpect(jsonPath("$.firstName", is("Kokosza")))
                .andExpect(jsonPath("$.lastName", is("Pojoak")))
                .andExpect(jsonPath("$.phoneNumber", is(Integer.parseInt(dto.getPhoneNumber().toString()))))
                .andExpect(jsonPath("$.email", is("kokoszka@o2.pl")))
                .andExpect(jsonPath("$.cvFileId", is(CV_FILE_ID)))
                .andExpect(jsonPath("$.coverLetterId", is(COVER_LETTER_FILE_ID)))
                .andExpect(jsonPath("$.status", is("HIRED")));
    }
}
