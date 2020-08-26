package com.hrsolutionsystem.hrss.model.service;

import com.hrsolutionsystem.hrss.model.domain.entity.CoverLetter;
import org.junit.Assert;
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
    private static final String COVER_LETTER_ID = "a45cc045-3185-466e-9d91-a91329060820";

    public void init() throws IOException {
        Path resourceDirectory = Paths.get("src","test","resources", "Noname");
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
        CoverLetter coverLetter = service.getFile(COVER_LETTER_ID);

        Assert.assertNotNull(coverLetter);
    }
}
