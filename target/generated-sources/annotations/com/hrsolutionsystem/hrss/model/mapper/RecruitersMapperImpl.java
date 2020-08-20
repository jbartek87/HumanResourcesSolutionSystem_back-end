package com.hrsolutionsystem.hrss.model.mapper;

import com.hrsolutionsystem.hrss.model.domain.dto.CompanyDto;
import com.hrsolutionsystem.hrss.model.domain.dto.CvDetailsDto;
import com.hrsolutionsystem.hrss.model.domain.dto.CvDetailsDto.CvDetailsDtoBuilder;
import com.hrsolutionsystem.hrss.model.domain.dto.InterviewDto;
import com.hrsolutionsystem.hrss.model.domain.dto.InterviewDto.InterviewDtoBuilder;
import com.hrsolutionsystem.hrss.model.domain.dto.RecruitersDto;
import com.hrsolutionsystem.hrss.model.domain.dto.RecruitersDto.RecruitersDtoBuilder;
import com.hrsolutionsystem.hrss.model.domain.entity.Company;
import com.hrsolutionsystem.hrss.model.domain.entity.CvDetails;
import com.hrsolutionsystem.hrss.model.domain.entity.CvDetails.CvDetailsBuilder;
import com.hrsolutionsystem.hrss.model.domain.entity.Interview;
import com.hrsolutionsystem.hrss.model.domain.entity.Interview.InterviewBuilder;
import com.hrsolutionsystem.hrss.model.domain.entity.Recruiters;
import com.hrsolutionsystem.hrss.model.domain.entity.Recruiters.RecruitersBuilder;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-08-20T09:29:04+0200",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 1.8.0_261 (Oracle Corporation)"
)
@Component
public class RecruitersMapperImpl implements RecruitersMapper {

    @Autowired
    private CompanyMapper companyMapper;

    @Override
    public RecruitersDto toDto(Recruiters recruiters) {
        if ( recruiters == null ) {
            return null;
        }

        RecruitersDtoBuilder recruitersDto = RecruitersDto.builder();

        recruitersDto.companyDtoList( companyMapper.toList( recruiters.getCompanies() ) );
        recruitersDto.cvDetailsDtoList( cvDetailsListToCvDetailsDtoList( recruiters.getCvDetailsList() ) );
        recruitersDto.interviewDtoList( interviewListToInterviewDtoList( recruiters.getInterviewList() ) );
        recruitersDto.id( recruiters.getId() );
        recruitersDto.login( recruiters.getLogin() );
        recruitersDto.password( recruiters.getPassword() );
        recruitersDto.firstName( recruiters.getFirstName() );
        recruitersDto.lastName( recruiters.getLastName() );
        recruitersDto.phoneNumber( recruiters.getPhoneNumber() );
        recruitersDto.email( recruiters.getEmail() );

        return recruitersDto.build();
    }

    @Override
    public Recruiters toMap(RecruitersDto recruitersDto) {
        if ( recruitersDto == null ) {
            return null;
        }

        RecruitersBuilder recruiters = Recruiters.builder();

        recruiters.cvDetailsList( cvDetailsDtoListToCvDetailsList( recruitersDto.getCvDetailsDtoList() ) );
        recruiters.companies( companyDtoListToCompanyList( recruitersDto.getCompanyDtoList() ) );
        recruiters.interviewList( interviewDtoListToInterviewList( recruitersDto.getInterviewDtoList() ) );
        recruiters.id( recruitersDto.getId() );
        recruiters.login( recruitersDto.getLogin() );
        recruiters.password( recruitersDto.getPassword() );
        recruiters.firstName( recruitersDto.getFirstName() );
        recruiters.lastName( recruitersDto.getLastName() );
        recruiters.phoneNumber( recruitersDto.getPhoneNumber() );
        recruiters.email( recruitersDto.getEmail() );

        return recruiters.build();
    }

    @Override
    public List<RecruitersDto> toList(List<Recruiters> list) {
        if ( list == null ) {
            return null;
        }

        List<RecruitersDto> list1 = new ArrayList<RecruitersDto>( list.size() );
        for ( Recruiters recruiters : list ) {
            list1.add( toDto( recruiters ) );
        }

        return list1;
    }

    protected CvDetailsDto cvDetailsToCvDetailsDto(CvDetails cvDetails) {
        if ( cvDetails == null ) {
            return null;
        }

        CvDetailsDtoBuilder cvDetailsDto = CvDetailsDto.builder();

        cvDetailsDto.id( cvDetails.getId() );
        cvDetailsDto.applyingPosition( cvDetails.getApplyingPosition() );
        cvDetailsDto.firstName( cvDetails.getFirstName() );
        cvDetailsDto.lastName( cvDetails.getLastName() );
        cvDetailsDto.phoneNumber( cvDetails.getPhoneNumber() );
        cvDetailsDto.email( cvDetails.getEmail() );
        cvDetailsDto.status( cvDetails.getStatus() );

        return cvDetailsDto.build();
    }

    protected List<CvDetailsDto> cvDetailsListToCvDetailsDtoList(List<CvDetails> list) {
        if ( list == null ) {
            return null;
        }

        List<CvDetailsDto> list1 = new ArrayList<CvDetailsDto>( list.size() );
        for ( CvDetails cvDetails : list ) {
            list1.add( cvDetailsToCvDetailsDto( cvDetails ) );
        }

        return list1;
    }

    protected InterviewDto interviewToInterviewDto(Interview interview) {
        if ( interview == null ) {
            return null;
        }

        InterviewDtoBuilder interviewDto = InterviewDto.builder();

        interviewDto.id( interview.getId() );
        interviewDto.interviewDate( interview.getInterviewDate() );
        interviewDto.location( interview.getLocation() );

        return interviewDto.build();
    }

    protected List<InterviewDto> interviewListToInterviewDtoList(List<Interview> list) {
        if ( list == null ) {
            return null;
        }

        List<InterviewDto> list1 = new ArrayList<InterviewDto>( list.size() );
        for ( Interview interview : list ) {
            list1.add( interviewToInterviewDto( interview ) );
        }

        return list1;
    }

    protected CvDetails cvDetailsDtoToCvDetails(CvDetailsDto cvDetailsDto) {
        if ( cvDetailsDto == null ) {
            return null;
        }

        CvDetailsBuilder cvDetails = CvDetails.builder();

        cvDetails.id( cvDetailsDto.getId() );
        cvDetails.applyingPosition( cvDetailsDto.getApplyingPosition() );
        cvDetails.firstName( cvDetailsDto.getFirstName() );
        cvDetails.lastName( cvDetailsDto.getLastName() );
        cvDetails.phoneNumber( cvDetailsDto.getPhoneNumber() );
        cvDetails.email( cvDetailsDto.getEmail() );
        cvDetails.status( cvDetailsDto.getStatus() );

        return cvDetails.build();
    }

    protected List<CvDetails> cvDetailsDtoListToCvDetailsList(List<CvDetailsDto> list) {
        if ( list == null ) {
            return null;
        }

        List<CvDetails> list1 = new ArrayList<CvDetails>( list.size() );
        for ( CvDetailsDto cvDetailsDto : list ) {
            list1.add( cvDetailsDtoToCvDetails( cvDetailsDto ) );
        }

        return list1;
    }

    protected Company companyDtoToCompany(CompanyDto companyDto) {
        if ( companyDto == null ) {
            return null;
        }

        Company company = new Company();

        company.setId( companyDto.getId() );
        company.setName( companyDto.getName() );
        company.setNip( companyDto.getNip() );
        company.setAddress( companyDto.getAddress() );

        return company;
    }

    protected List<Company> companyDtoListToCompanyList(List<CompanyDto> list) {
        if ( list == null ) {
            return null;
        }

        List<Company> list1 = new ArrayList<Company>( list.size() );
        for ( CompanyDto companyDto : list ) {
            list1.add( companyDtoToCompany( companyDto ) );
        }

        return list1;
    }

    protected Interview interviewDtoToInterview(InterviewDto interviewDto) {
        if ( interviewDto == null ) {
            return null;
        }

        InterviewBuilder interview = Interview.builder();

        interview.id( interviewDto.getId() );
        interview.interviewDate( interviewDto.getInterviewDate() );
        interview.location( interviewDto.getLocation() );

        return interview.build();
    }

    protected List<Interview> interviewDtoListToInterviewList(List<InterviewDto> list) {
        if ( list == null ) {
            return null;
        }

        List<Interview> list1 = new ArrayList<Interview>( list.size() );
        for ( InterviewDto interviewDto : list ) {
            list1.add( interviewDtoToInterview( interviewDto ) );
        }

        return list1;
    }
}
