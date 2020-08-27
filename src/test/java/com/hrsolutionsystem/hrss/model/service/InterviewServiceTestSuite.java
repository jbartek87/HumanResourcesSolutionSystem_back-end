package com.hrsolutionsystem.hrss.model.service;

import com.hrsolutionsystem.hrss.model.domain.dto.CvDetailsDto;
import com.hrsolutionsystem.hrss.model.domain.dto.InterviewDto;
import com.hrsolutionsystem.hrss.model.domain.dto.RecruitersDto;
import com.hrsolutionsystem.hrss.model.domain.entity.CoverLetter;
import com.hrsolutionsystem.hrss.model.domain.entity.CvDetails;
import com.hrsolutionsystem.hrss.model.domain.entity.CvFile;
import com.hrsolutionsystem.hrss.model.domain.entity.Interview;
import com.hrsolutionsystem.hrss.model.domain.enums.CvStatus;
import com.hrsolutionsystem.hrss.model.domain.enums.InterviewLocation;
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
import java.time.LocalDate;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class InterviewServiceTestSuite {
    @Autowired
    private InterviewService service;

    @Autowired
    private CvDetailsService cvDetailsService;

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
    private Long recruiterId;
    private Long cvDetailsId;


    public void initFile() throws IOException {
        cvFile = new CvFile();
        Path resourceDirectory = Paths.get("src", "test", "resources", "dummy.pdf");
        File file = new File(resourceDirectory.toFile().getAbsolutePath());
        FileInputStream fileInputStream = new FileInputStream(file);
        multipartFile = new MockMultipartFile(file.getName(), fileInputStream);
        cvFileService.storeFile(multipartFile);
        cvFileId = cvFileService.getFileList().get(0).getId();
    }

    public void initLetter() throws IOException {
        coverLetter = new CoverLetter();
        Path resourceDirectory = Paths.get("src", "test", "resources", "Noname");
        File file = new File(resourceDirectory.toFile().getAbsolutePath());
        FileInputStream fileInputStream = new FileInputStream(file);
        multipartFileLetter = new MockMultipartFile(file.getName(), fileInputStream);
        coverLetterService.storeFile(multipartFileLetter);
        coverLetterId = coverLetterService.getList().get(0).getId();
    }

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

    @Before
    public void initCvDet() throws IOException {
        initFile();
        initLetter();
        initRecruiter();
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
        CvDetailsDto cvDetailsTest = cvDetailsService.save(dto);
        cvDetailsId = cvDetailsTest.getId();

    }

    @Test
    public void saveInterview() {
        //Given
        InterviewDto interviewDto = new InterviewDto();
        interviewDto.setCvDetailsId(cvDetailsId);
        interviewDto.setRecruiterId(recruiterId);
        interviewDto.setInterviewDate(LocalDate.of(2020, 10 , 10));
        interviewDto.setLocation(InterviewLocation.IN_OFFICE);
        //When
        InterviewDto sampleInterview = service.save(interviewDto);
        Long cvId = sampleInterview.getCvDetailsId();
        Long recId = sampleInterview.getRecruiterId();
        //Then
        Assert.assertEquals(LocalDate.of(2020,10,10), sampleInterview.getInterviewDate());
        Assert.assertEquals(InterviewLocation.IN_OFFICE, sampleInterview.getLocation());
        Assert.assertEquals(cvDetailsId, cvId);
        Assert.assertEquals(recruiterId, recId);

    }


    @Test
    public void findByIdTest() {
        InterviewDto interviewDto = new InterviewDto();
        interviewDto.setCvDetailsId(cvDetailsId);
        interviewDto.setRecruiterId(recruiterId);
        interviewDto.setInterviewDate(LocalDate.now());
        interviewDto.setLocation(InterviewLocation.IN_OFFICE);

        InterviewDto interDto = service.save(interviewDto);

        Assert.assertNotNull(service.findById(interDto.getId()));
    }

    //
    @Test
    public void deleteById() {
        InterviewDto interviewDto = new InterviewDto();
        interviewDto.setCvDetailsId(cvDetailsId);
        interviewDto.setRecruiterId(recruiterId);
        interviewDto.setInterviewDate(LocalDate.now());
        interviewDto.setLocation(InterviewLocation.IN_OFFICE);

        InterviewDto interDto = service.save(interviewDto);

        try {
            service.deleteById(interDto.getId());
        } catch (Exception e) {
            Assert.assertNull(e);
        }
    }

}
