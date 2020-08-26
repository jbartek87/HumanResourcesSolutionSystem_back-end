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
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class CvFileServiceTestSuite {
    @Autowired
    private CvFileService service;

    private MultipartFile multipartFile;

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
    public void getFileList(){
        service.storeFile(multipartFile);
        List<CvFile> testList;
        testList = service.getFileList();
        Assert.assertEquals(1, testList.size());

    }

}
