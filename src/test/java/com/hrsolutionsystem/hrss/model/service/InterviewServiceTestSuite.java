package com.hrsolutionsystem.hrss.model.service;

import com.hrsolutionsystem.hrss.model.domain.dto.CvDetailsDto;
import com.hrsolutionsystem.hrss.model.domain.dto.InterviewDto;
import com.hrsolutionsystem.hrss.model.domain.dto.RecruitersDto;
import com.hrsolutionsystem.hrss.model.domain.enums.CvStatus;
import com.hrsolutionsystem.hrss.model.domain.enums.InterviewLocation;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.time.LocalDate;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class InterviewServiceTestSuite {
    @Autowired
    private InterviewService service;

    @Autowired
    private RecruitersService recruitersService;

    @Autowired
    CvDetailsService cvDetailsService;

    private final static String CV_FILE_ID = "5044a5d4-b225-40e9-b93a-17f2b0a54fb1";
    private final static String COVER_LETTER_FILE_ID = "a45cc045-3185-466e-9d91-a91329060820";
    private Long recId;
    private Long cvDetId;

    @Before
    public void init() {
        RecruitersDto recruitersDto = new RecruitersDto();
        recruitersDto.setLogin("recruiter_login");
        recruitersDto.setPassword("123QWERTY456");
        recruitersDto.setFirstName("Recruiter I");
        recruitersDto.setLastName("Jummy");
        recruitersDto.setPhoneNumber(333333333L);
        recruitersDto.setEmail("recIJummy@gmail.com");

        RecruitersDto rec = recruitersService.save(recruitersDto);
        recId = rec.getId();

        CvDetailsDto cvDetailsDto = new CvDetailsDto();
        cvDetailsDto.setApplyingPosition("Junior Java Dev");
        cvDetailsDto.setFirstName("Junior II");
        cvDetailsDto.setLastName("Jackyy");
        cvDetailsDto.setPhoneNumber(123123123L);
        cvDetailsDto.setEmail("jrDev@o2.pl");
        cvDetailsDto.setRecruiterId(recId);
        cvDetailsDto.setStatus(CvStatus.IN_QUEUE);
        cvDetailsDto.setCvFileId(CV_FILE_ID);
        cvDetailsDto.setCoverLetterId(COVER_LETTER_FILE_ID);

        CvDetailsDto cvDet = cvDetailsService.save(cvDetailsDto);
        cvDetId = cvDet.getId();
    }

    @Test
    public void saveTest() {
        InterviewDto interviewDto = new InterviewDto();
        interviewDto.setCvDetailsId(cvDetId);
        interviewDto.setRecruiterId(recId);
        interviewDto.setInterviewDate(LocalDate.now());
        interviewDto.setLocation(InterviewLocation.IN_OFFICE);

        InterviewDto interDto = service.save(interviewDto);

        Assert.assertNotNull(interDto);
    }

    @Test
    public void findByIdTest() {
        InterviewDto interviewDto = new InterviewDto();
        interviewDto.setCvDetailsId(cvDetId);
        interviewDto.setRecruiterId(recId);
        interviewDto.setInterviewDate(LocalDate.now());
        interviewDto.setLocation(InterviewLocation.IN_OFFICE);

        InterviewDto interDto = service.save(interviewDto);

        Assert.assertNotNull(service.findById(interDto.getId()));
    }

    @Test
    public void deleteById() {
        InterviewDto interviewDto = new InterviewDto();
        interviewDto.setCvDetailsId(cvDetId);
        interviewDto.setRecruiterId(recId);
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
