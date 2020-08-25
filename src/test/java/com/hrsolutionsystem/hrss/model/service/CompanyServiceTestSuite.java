package com.hrsolutionsystem.hrss.model.service;

import com.hrsolutionsystem.hrss.model.domain.dto.CompanyDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class CompanyServiceTestSuite {

    @Autowired
    private CompanyService service;


    @Test
    public void testFindById() {
        //Given
        CompanyDto companyDto = new CompanyDto();
        companyDto.setName("Opel");
        companyDto.setAddress("ZZZZ");
        companyDto.setNip(111L);
        //When
        CompanyDto testCompany = service.save(companyDto);
        CompanyDto findCompany = service.findById(testCompany.getId());
        long testNip = findCompany.getNip();
        //Then
        assertEquals("Opel", findCompany.getName());
        assertEquals("ZZZZ", findCompany.getAddress());
        assertEquals(111L, testNip);
    }

    @Test
    public void testGetList(){
        //Given
        CompanyDto companyDto = new CompanyDto();
        companyDto.setName("Opel");
        companyDto.setAddress("ZZZZ");
        companyDto.setNip(111L);

        CompanyDto companyDto2 = new CompanyDto();
        companyDto2.setName("Skanska");
        companyDto2.setAddress("Berlin");
        companyDto2.setNip(9999L);
        //When
        service.save(companyDto);
        service.save(companyDto2);
        List<CompanyDto> testList = service.getList();
        //Then
        assertEquals(2, testList.size());
    }

    @Test
    public void testDeleteById(){
        //Given
        CompanyDto companyDto = new CompanyDto();
        companyDto.setName("Opel");
        companyDto.setAddress("ZZZZ");
        companyDto.setNip(111L);

        CompanyDto companyDto2 = new CompanyDto();
        companyDto2.setName("Skanska");
        companyDto2.setAddress("Berlin");
        companyDto2.setNip(9999L);
        CompanyDto testComp1 = service.save(companyDto);
        CompanyDto testComp2 = service.save(companyDto2);
        //When
        service.deleteById(testComp1.getId());
        List<CompanyDto> testList = service.getList();
        //Then
        assertEquals(1, testList.size());
    }




}