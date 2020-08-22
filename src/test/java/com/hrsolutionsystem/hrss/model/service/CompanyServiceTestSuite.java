//package com.hrsolutionsystem.hrss.model.service;
//
//import com.hrsolutionsystem.hrss.model.domain.dto.CompanyDto;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.transaction.annotation.Transactional;
//
//import static org.junit.Assert.assertEquals;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//@Transactional
//public class CompanyServiceTestSuite {
//
//    @Autowired
//    private CompanyService service;
//
//
//    @Test
//    public void findById(){
//        //Given
//        CompanyDto companyDto = new CompanyDto();
//        companyDto.setId(1L);
//        companyDto.setName("Opel");
//        companyDto.setAddress("ZZZZ");
//        companyDto.setNip(111L);
//        //When
////      ompanyDto  service.save(companyDto);
//        CompanyDto findCompany = service.findById(19L);
//        //Then
//        assertEquals("Opel", findCompany.getName());
//
//    }
//
//}