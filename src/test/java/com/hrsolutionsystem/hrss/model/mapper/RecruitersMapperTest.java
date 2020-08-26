package com.hrsolutionsystem.hrss.model.mapper;

import com.hrsolutionsystem.hrss.model.domain.dto.RecruitersDto;
import com.hrsolutionsystem.hrss.model.domain.entity.Company;
import com.hrsolutionsystem.hrss.model.domain.entity.CvDetails;
import com.hrsolutionsystem.hrss.model.domain.entity.Interview;
import com.hrsolutionsystem.hrss.model.domain.entity.Recruiters;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class RecruitersMapperTest {
    RecruitersMapper mapper = new com.hrsolutionsystem.hrss.model.mapper.RecruitersMapperImpl();
    @Test
    public void testToDto(){
        //Given
        List<Interview> interviews = new ArrayList<>();
        List<CvDetails> cvDetails = new ArrayList<>();
        List<Company> companies = new ArrayList<>();
        Recruiters testRecruiter = new Recruiters(1L, "Terminator", "12345", "John",
                "Cyna", 12345L, "cyna@wp.pl", interviews, cvDetails,companies );
        //When
        RecruitersDto recruitersDto = mapper.toDto(testRecruiter);
        long id = recruitersDto.getId();
        long phone = recruitersDto.getPhoneNumber();
        //Then
        assertEquals(1L, id);
        assertEquals("Terminator", recruitersDto.getLogin());
        assertEquals("12345", recruitersDto.getPassword());
        assertEquals("John", recruitersDto.getFirstName());
        assertEquals("Cyna", recruitersDto.getLastName());
        assertEquals(12345, phone);
        assertEquals(0, interviews.size());
        assertEquals(0, cvDetails.size());
        assertEquals(0, companies.size());
    }

    @Test
    public void testToMap(){
        //Given
        RecruitersDto recruitersDto = new RecruitersDto(1L, "Jacek", "666", "Jack",
                "Sparrow", 1234L, "jack@black.pl");
        //When
        Recruiters recruiters = mapper.toMap(recruitersDto);
        long id = recruitersDto.getId();
        long phone = recruiters.getPhoneNumber();
        //Then
        assertEquals(1L, id);
        assertEquals("Jacek", recruiters.getLogin());
        assertEquals("666", recruiters.getPassword());
        assertEquals("Jack", recruiters.getFirstName());
        assertEquals("Sparrow", recruiters.getLastName());
        assertEquals(1234, phone);
        assertEquals("jack@black.pl", recruiters.getEmail());
    }

    @Test
    public void testToList(){
        //Given
        List<Interview> interviews = new ArrayList<>();
        List<CvDetails> cvDetails = new ArrayList<>();
        List<Company> companies = new ArrayList<>();
        List<Interview> interviews2 = new ArrayList<>();
        List<CvDetails> cvDetails2 = new ArrayList<>();
        List<Company> companies2 = new ArrayList<>();

        List<Recruiters> recruitersList = new ArrayList<>();

        Recruiters testRecruiter = new Recruiters(1L, "Terminator", "12345", "John",
                "Cyna", 12345L, "cyna@wp.pl", interviews, cvDetails,companies );

        Recruiters testRecruiter2 = new Recruiters(2L, "panda", "9876", "Patty",
                "Small", 67899L, "pati@wp.pl", interviews2, cvDetails2,companies2 );
        recruitersList.add(testRecruiter);
        recruitersList.add(testRecruiter2);
        //When
        List<RecruitersDto> recruitersDtoList = mapper.toList(recruitersList);
        long idFirst = recruitersDtoList.get(0).getId();
        long idSecond = recruitersDtoList.get(1).getId();
        long phoneFirst = recruitersDtoList.get(0).getPhoneNumber();
        long phoneSecond = recruitersDtoList.get(1).getPhoneNumber();
        //Then
        assertEquals(1L, idFirst);
        assertEquals(2L, idSecond);
        assertEquals("Terminator", recruitersDtoList.get(0).getLogin());
        assertEquals("panda", recruitersDtoList.get(1).getLogin());
        assertEquals("12345", recruitersDtoList.get(0).getPassword());
        assertEquals("9876", recruitersDtoList.get(1).getPassword());
        assertEquals("John", recruitersDtoList.get(0).getFirstName());
        assertEquals("Patty", recruitersDtoList.get(1).getFirstName());
        assertEquals("Cyna", recruitersDtoList.get(0).getLastName());
        assertEquals("Small", recruitersDtoList.get(1).getLastName());
        assertEquals(12345L, phoneFirst);
        assertEquals(67899L, phoneSecond);
        assertEquals("cyna@wp.pl",recruitersDtoList.get(0).getEmail());
        assertEquals("pati@wp.pl", recruitersDtoList.get(1).getEmail());

    }

}