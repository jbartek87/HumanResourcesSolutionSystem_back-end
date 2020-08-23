package com.hrsolutionsystem.hrss.model.mapper;

import com.hrsolutionsystem.hrss.model.domain.dto.InterviewDto;
import com.hrsolutionsystem.hrss.model.domain.entity.*;
import com.hrsolutionsystem.hrss.model.domain.enums.CvStatus;
import com.hrsolutionsystem.hrss.model.domain.enums.InterviewLocation;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class InterviewMapperTestSuite {
    InterviewMapper mapper = new InterviewMapperImpl();

    @Test
    public void toMapTest(){
        //Given
        InterviewDto interviewDto = new InterviewDto();
        interviewDto.setId(1L);
        interviewDto.setInterviewDate(LocalDate.of(2020, 10 , 10));
        interviewDto.setLocation(InterviewLocation.IN_OFFICE);
        interviewDto.setRecruiterId(1L);
        interviewDto.setCvDetailsId(1L);
        //When
        Interview interview = mapper.toMap(interviewDto);
        long testInterviewId = interview.getId();
        long testRecruiterId = interview.getRecruiter().getId();
        long testCvDetailsId = interview.getCvDetails().getId();
        //Then
        assertEquals(1L, testInterviewId);
        assertEquals(LocalDate.of(2020, 10, 10), interview.getInterviewDate());
        assertEquals(InterviewLocation.IN_OFFICE, interview.getLocation());
        assertEquals(1, testRecruiterId);
        assertEquals(1, testCvDetailsId);
    }

    @Test
    public void testToDto() {
        //Given
        List<Interview> testList = new ArrayList<>();
        List<CvDetails> cvDetails = new ArrayList<>();
        List<Company> companies = new ArrayList<>();
        CvDetails testDetails = new CvDetails(1L, "java", "Bartek", "Kowal",
                12345L, "jb@com.pl", CvStatus.ACCEPTED, new Recruiters(), testList,
                new CvFile(), new CoverLetter());
        Recruiters testRecruiter = new Recruiters(1L, "Terminator", "12345", "John", "Cyna", 12345L, "cyna@wp.pl",
                testList, cvDetails,companies );
        Interview interview = new Interview();
        interview.setId(1L);
        interview.setInterviewDate(LocalDate.of(2020, 10, 10));
        interview.setLocation(InterviewLocation.IN_OFFICE);
        interview.setRecruiter(testRecruiter);
        interview.setCvDetails(testDetails);
        //When
        InterviewDto interviewDto = mapper.toDto(interview);
        long testInterviewDtoId = interviewDto.getId();
        long testRecruiterId = interviewDto.getRecruiterId();
        long testCvDetailsId = interviewDto.getCvDetailsId();
        //Then
        assertEquals(1L, testInterviewDtoId);
        assertEquals(LocalDate.of(2020, 10, 10), interviewDto.getInterviewDate());
        assertEquals(InterviewLocation.IN_OFFICE, interviewDto.getLocation());
        assertEquals(1, testRecruiterId);
        assertEquals(1, testCvDetailsId);
    }
}