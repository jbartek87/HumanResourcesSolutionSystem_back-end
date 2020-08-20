package com.hrsolutionsystem.hrss.model.mapper;

import com.hrsolutionsystem.hrss.model.domain.dto.InterviewDto;
import com.hrsolutionsystem.hrss.model.domain.dto.InterviewDto.InterviewDtoBuilder;
import com.hrsolutionsystem.hrss.model.domain.entity.Interview;
import com.hrsolutionsystem.hrss.model.domain.entity.Interview.InterviewBuilder;
import com.hrsolutionsystem.hrss.model.domain.entity.Recruiters;
import com.hrsolutionsystem.hrss.model.domain.entity.Recruiters.RecruitersBuilder;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-08-20T09:29:05+0200",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 1.8.0_261 (Oracle Corporation)"
)
@Component
public class InterviewMapperImpl implements InterviewMapper {

    @Override
    public InterviewDto toDto(Interview interview) {
        if ( interview == null ) {
            return null;
        }

        InterviewDtoBuilder interviewDto = InterviewDto.builder();

        interviewDto.recruiterId( interviewRecruiterId( interview ) );
        interviewDto.id( interview.getId() );
        interviewDto.interviewDate( interview.getInterviewDate() );
        interviewDto.location( interview.getLocation() );

        return interviewDto.build();
    }

    @Override
    public Interview toMap(InterviewDto interviewDto) {
        if ( interviewDto == null ) {
            return null;
        }

        InterviewBuilder interview = Interview.builder();

        interview.recruiter( interviewDtoToRecruiters( interviewDto ) );
        interview.id( interviewDto.getId() );
        interview.interviewDate( interviewDto.getInterviewDate() );
        interview.location( interviewDto.getLocation() );

        return interview.build();
    }

    private Long interviewRecruiterId(Interview interview) {
        if ( interview == null ) {
            return null;
        }
        Recruiters recruiter = interview.getRecruiter();
        if ( recruiter == null ) {
            return null;
        }
        Long id = recruiter.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    protected Recruiters interviewDtoToRecruiters(InterviewDto interviewDto) {
        if ( interviewDto == null ) {
            return null;
        }

        RecruitersBuilder recruiters = Recruiters.builder();

        recruiters.id( interviewDto.getRecruiterId() );

        return recruiters.build();
    }
}
