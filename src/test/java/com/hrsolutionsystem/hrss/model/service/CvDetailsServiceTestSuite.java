package com.hrsolutionsystem.hrss.model.service;

import com.hrsolutionsystem.hrss.exception.cvDetails.CvDetailsNotFoundException;
import com.hrsolutionsystem.hrss.model.domain.dto.CvDetailsDto;
import com.hrsolutionsystem.hrss.model.domain.dto.RecruitersDto;
import com.hrsolutionsystem.hrss.model.domain.entity.CoverLetter;
import com.hrsolutionsystem.hrss.model.domain.entity.CvFile;
import com.hrsolutionsystem.hrss.model.domain.enums.CvStatus;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class CvDetailsServiceTestSuite {
    @Autowired
    private CvDetailsService service;

    @Autowired
    private CvFileService cvFileService;

    @Autowired
    private CoverLetterService coverLetterService;

    @Autowired
    private RecruitersService recruitersService;

    private MultipartFile multipartFile;
    private MultipartFile multipartFileLetter;
    private RecruitersDto recruitersDto;
    private CoverLetter coverLetter;
    private CvFile cvFile;
    private String cvFileId;
    private String coverLetterId;
    private long recruiterId;


    @Before
    public void initFile() throws IOException {
        cvFile = new CvFile();
        Path resourceDirectory = Paths.get("src", "test", "resources", "dummy.pdf");
        File file = new File(resourceDirectory.toFile().getAbsolutePath());
        FileInputStream fileInputStream = new FileInputStream(file);
        multipartFile = new MockMultipartFile(file.getName(), fileInputStream);
        cvFileService.storeFile(multipartFile);
        cvFileId = cvFileService.getFileList().get(0).getId();
    }

    @Before
    public void initLetter() throws IOException {
        coverLetter = new CoverLetter();
        Path resourceDirectory = Paths.get("src", "test", "resources", "Noname");
        File file = new File(resourceDirectory.toFile().getAbsolutePath());
        FileInputStream fileInputStream = new FileInputStream(file);
        multipartFileLetter = new MockMultipartFile(file.getName(), fileInputStream);
        coverLetterService.storeFile(multipartFileLetter);
        coverLetterId = coverLetterService.getList().get(0).getId();
    }

    @Before
    public void initRecruiter() {
        recruitersDto = new RecruitersDto();
        recruitersDto.setLogin("Admin");
        recruitersDto.setPassword("12345");
        recruitersDto.setFirstName("Paul");
        recruitersDto.setLastName("McDonald");
        recruitersDto.setPhoneNumber(600L);
        recruitersDto.setEmail("admin@wp.pl");
        RecruitersDto recruitersDtoDb = recruitersService.save(recruitersDto);
        recruiterId = recruitersDtoDb.getId();
    }

    @Test
    public void saveTest() {
        //Given
        CvDetailsDto dto = new CvDetailsDto();
        dto.setApplyingPosition("Junior Developer Life Matters");
        dto.setEmail("kokoszka@o2.pl");
        dto.setFirstName("Kate");
        dto.setLastName("Rushmore");
        dto.setPhoneNumber(123123123L);
        dto.setStatus(CvStatus.HIRED);
        dto.setRecruiterId(recruiterId);
        dto.setCoverLetterId(coverLetterId);
        dto.setCvFileId(cvFileId);
        //When
        CvDetailsDto details = service.save(dto);
        long phone = details.getPhoneNumber();

        Assert.assertEquals("kokoszka@o2.pl", details.getEmail());
        Assert.assertEquals("Junior Developer Life Matters", details.getApplyingPosition());
        Assert.assertEquals("Kate", details.getFirstName());
        Assert.assertEquals("Rushmore", details.getLastName());
        Assert.assertEquals(123123123, phone);
        Assert.assertEquals(CvStatus.HIRED, details.getStatus());
        Assert.assertEquals(coverLetterId, details.getCoverLetterId());
        Assert.assertEquals(cvFileId, details.getCvFileId());

    }

    @Test
    public void findById() {
        //Given
        CvDetailsDto dto = new CvDetailsDto();
        dto.setApplyingPosition("Junior Developer Life Matters");
        dto.setCoverLetterId(coverLetterId);
        dto.setCvFileId(cvFileId);
        dto.setEmail("kokoszka@o2.pl");
        dto.setFirstName("Kokosza");
        dto.setLastName("Pojoak");
        dto.setPhoneNumber(123123123L);
        dto.setStatus(CvStatus.HIRED);
        dto.setRecruiterId(recruiterId);
        CvDetailsDto details = service.save(dto);
        //When
        CvDetailsDto detailsTest = service.findById(details.getId());
        //Then
        Assert.assertNotNull(detailsTest);
    }

    @Test(expected = CvDetailsNotFoundException.class)
    public void notFound() {
        Long notExistingId = 312312553L;
        Assert.assertNull(service.findById(notExistingId));
    }
}
