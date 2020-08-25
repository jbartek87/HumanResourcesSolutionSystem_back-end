package com.hrsolutionsystem.hrss.model.service;

import com.hrsolutionsystem.hrss.model.domain.dto.RecruitersDto;
import com.hrsolutionsystem.hrss.model.domain.entity.Recruiters;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class RecruitersServiceTestSuite {
    @Autowired
    private RecruitersService service;

    RecruitersDto recruiter;
    @Before
    public void init(){
        recruiter = new RecruitersDto();
        recruiter.setLogin("jbart");
        recruiter.setPassword("qwerty");
        recruiter.setFirstName("Kenny");
        recruiter.setLastName("Jimmy");
        recruiter.setPhoneNumber(9999L);
        recruiter.setEmail("b2b@yr.no");
    }

    @Test
    public void findByIdTest(){
        //Given
        RecruitersDto recruitersDto = service.save(recruiter);
        long id = recruitersDto.getId();
        long phone = recruitersDto.getPhoneNumber();
        //When
        RecruitersDto recTest = service.findById(id);
        //Then
        assertEquals("jbart", recTest.getLogin());
        assertEquals("qwerty", recTest.getPassword());
        assertEquals("Kenny", recTest.getFirstName());
        assertEquals("Jimmy", recTest.getLastName());
        assertEquals(9999, phone);
        assertEquals("b2b@yr.no", recTest.getEmail());
    }

    @Test
    public void getListTest(){
        //Given
        service.save(recruiter);
        service.save(recruiter);
        //When
        List<RecruitersDto> testList = service.recruitersGetList();
        //Then
        assertEquals(2, testList.size());
    }

    @Test
    public void deleteByIdTest(){
        //Given
        RecruitersDto firstRec = service.save(recruiter);
        RecruitersDto secondRec = service.save(recruiter);
        //When
        service.deleteByID(firstRec.getId());
        //
        assertEquals(1, service.recruitersGetList().size());
    }

    @Test
    public void updateTest(){
        //Given
        RecruitersDto recruitersDto = service.save(recruiter);
        long id = recruitersDto.getId();
        RecruitersDto recruiter2 = new RecruitersDto();
        recruiter2.setId(id);
        recruiter2.setLogin("kley");
        recruiter2.setPassword("1234");
        recruiter2.setFirstName("Tim");
        recruiter2.setLastName("Snap");
        recruiter2.setPhoneNumber(1234L);
        recruiter2.setEmail("yyy@yr.no");
        //When
        service.update(recruiter2);
        //Then
        assertEquals("kley", service.findById(id).getLogin());
    }
}