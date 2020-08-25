package com.hrsolutionsystem.hrss.model.service;

import com.hrsolutionsystem.hrss.model.domain.entity.CvFile;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class CvFileServiceTestSuite {
    @Autowired
    private CvFileService service;

    private MultipartFile multipartFile;
    private static final String CV_FILE_ID = "5044a5d4-b225-40e9-b93a-17f2b0a54fb1";

    @Before
    public void init() throws IOException {
        Path resourceDirectory = Paths.get("src","test","resources", "dummy.pdf");
        File file = new File(resourceDirectory.toFile().getAbsolutePath());
        FileInputStream fileInputStream = new FileInputStream(file);

        multipartFile = new MockMultipartFile(file.getName(), fileInputStream);
    }

    @Test
    public void storeFileTest() throws IOException {
        init();

        try {
            service.storeFile(multipartFile);
        } catch (Exception e) {
            Assert.assertNull(e);
        }
    }

    @Test
    public void getFileTest() {
        CvFile cvFile;

        cvFile = service.getFile(CV_FILE_ID);

        Assert.assertNotNull(cvFile);
    }
}
