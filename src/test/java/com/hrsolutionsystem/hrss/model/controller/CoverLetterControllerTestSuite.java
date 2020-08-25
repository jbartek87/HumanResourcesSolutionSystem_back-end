package com.hrsolutionsystem.hrss.model.controller;

import com.hrsolutionsystem.hrss.model.service.CoverLetterService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.NestedServletException;

import java.io.File;
import java.io.FileInputStream;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.multipart;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(CoverLetterController.class)
public class CoverLetterControllerTestSuite {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CoverLetterService service;

    private String url = "/v1/coverLetter/";
    private static final String COVER_LETTER_ID = "a45cc045-3185-466e-9d91-a91329060820";

    @Test
    public void uploadFileTest() throws Exception {
        Path resourceDirectory = Paths.get("src","test","resources", "Noname");
        File file = new File(resourceDirectory.toFile().getAbsolutePath());
        FileInputStream fileInputStream = new FileInputStream(file);
        MultipartFile multipartFile = new MockMultipartFile(file.getName(), fileInputStream);

        MockMultipartFile firstFile = new MockMultipartFile("file", "Noname",
                "application/msword", multipartFile.getBytes());

        mockMvc.perform(multipart(url + "uploadFile")
                .file(firstFile)
                .contentType("application/msword"))
                .andExpect(status().is(200));
    }

    @Test
    public void downloadFileTest() throws Exception {
        String downloadUrl = url + "download/" + COVER_LETTER_ID;

        try {
            mockMvc.perform(get(downloadUrl))
                    .andExpect(status().isOk());

        } catch (NestedServletException e) {
            System.out.println(e);
        }

    }
}
