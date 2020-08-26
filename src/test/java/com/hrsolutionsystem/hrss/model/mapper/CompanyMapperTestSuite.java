package com.hrsolutionsystem.hrss.model.mapper;

import com.hrsolutionsystem.hrss.model.domain.dto.CompanyDto;
import com.hrsolutionsystem.hrss.model.domain.entity.Company;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CompanyMapperTestSuite {
    CompanyMapper mapper = new com.hrsolutionsystem.hrss.model.mapper.CompanyMapperImpl();
    @Test
    public void testToMap(){
        //Given
        CompanyDto companyDto = new CompanyDto(1L, "dsadsa", 1122L, "New york");
        //Then
        Company company = mapper.toMap(companyDto);
        long id = company.getId();
        long nip = company.getNip();
        //When
        assertEquals(1L, id);
        assertEquals("dsadsa", company.getName());
        assertEquals(1122, nip);
        assertEquals("New york", company.getAddress());
    }

    @Test
    public void testToDto(){
        //Given
        Company company = new Company();
        company.setId(1L);
        company.setAddress("zielona");
        company.setNip(1234L);
        company.setName("XxX");
        //When
        CompanyDto companyDto = mapper.toDto(company);
        long id = company.getId();
        long nip = company.getNip();
        //Then
        assertEquals(1L, id);
        assertEquals(1234, nip);
        assertEquals("zielona", companyDto.getAddress());
        assertEquals("XxX", companyDto.getName());
    }

}