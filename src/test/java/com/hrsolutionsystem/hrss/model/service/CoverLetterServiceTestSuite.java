package com.hrsolutionsystem.hrss.model.service;

import com.hrsolutionsystem.hrss.model.domain.entity.CoverLetter;
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
public class CoverLetterServiceTestSuite {
    @Autowired
    private CoverLetterService service;

    private MultipartFile multipartFile;

    @Before
    public void init() throws IOException {
        Path resourceDirectory = Paths.get("src", "test", "resources", "Noname");
        File file = new File(resourceDirectory.toFile().getAbsolutePath());
        FileInputStream fileInputStream = new FileInputStream(file);
        multipartFile = new MockMultipartFile(file.getName(), fileInputStream);
    }

    @Test
    public void storeFileTest() throws IOException {
        try {
            service.storeFile(multipartFile);
        } catch (Exception e) {
            Assert.assertNull(e);
        }
    }

    @Test
    public void getFileTest() {
        service.storeFile(multipartFile);
        String id = service.getList().get(0).getId();
        CoverLetter coverLetter = service.getFile(id);

        Assert.assertNotNull(coverLetter);
    }
}
