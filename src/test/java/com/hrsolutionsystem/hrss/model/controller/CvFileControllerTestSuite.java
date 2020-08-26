package com.hrsolutionsystem.hrss.model.controller;

import com.hrsolutionsystem.hrss.model.service.CvFileService;
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
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(CvFileController.class)
public class CvFileControllerTestSuite {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CvFileService service;

    private String url = "/v1/cvFile/";
    private static final String CV_FILE_ID = "5044a5d4-b225-40e9-b93a-17f2b0a54fb1";

    @Test
    public void uploadFileTest() throws Exception {
        Path resourceDirectory = Paths.get("src","test","resources", "dummy.pdf");
        File file = new File(resourceDirectory.toFile().getAbsolutePath());
        FileInputStream fileInputStream = new FileInputStream(file);
        MultipartFile multipartFile = new MockMultipartFile(file.getName(), fileInputStream);

        MockMultipartFile firstFile = new MockMultipartFile("file", "dummy.pdf",
                "application/pdf", multipartFile.getBytes());

        mockMvc.perform(multipart(url + "uploadFile")
                .file(firstFile)
        .contentType("application/pdf"))
                .andExpect(status().is(200));
    }

    @Test
    public void downloadFileTest() throws Exception {
        String downloadUrl = url + "download/" + CV_FILE_ID;

        try {
            mockMvc.perform(get(downloadUrl))
            .andExpect(status().isOk());

        } catch (NestedServletException e) {
            System.out.println(e);
        }

    }
}
