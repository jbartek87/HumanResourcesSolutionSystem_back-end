package com.hrsolutionsystem.hrss.model.mapper;

import com.hrsolutionsystem.hrss.model.domain.dto.CompanyDto;
import com.hrsolutionsystem.hrss.model.domain.dto.RecruitersDto;
import com.hrsolutionsystem.hrss.model.domain.dto.RecruitersDto.RecruitersDtoBuilder;
import com.hrsolutionsystem.hrss.model.domain.dto.WantedEmployeeDto;
import com.hrsolutionsystem.hrss.model.domain.entity.Company;
import com.hrsolutionsystem.hrss.model.domain.entity.Recruiters;
import com.hrsolutionsystem.hrss.model.domain.entity.Recruiters.RecruitersBuilder;
import com.hrsolutionsystem.hrss.model.domain.entity.WantedEmployee;
import com.hrsolutionsystem.hrss.model.domain.entity.WantedEmployee.WantedEmployeeBuilder;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-08-20T09:29:05+0200",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 1.8.0_261 (Oracle Corporation)"
)
@Component
public class CompanyMapperImpl implements CompanyMapper {

    @Autowired
    private WantedEmployeeMapper wantedEmployeeMapper;

    @Override
    public CompanyDto toDto(Company company) {
        if ( company == null ) {
            return null;
        }

        CompanyDto companyDto = new CompanyDto();

        companyDto.setRecruitersDtoList( recruitersListToRecruitersDtoList( company.getRecruiters() ) );
        companyDto.setWantedEmployeeDtoList( wantedEmployeeMapper.toList( company.getWantedEmployeeList() ) );
        companyDto.setId( company.getId() );
        companyDto.setName( company.getName() );
        companyDto.setNip( company.getNip() );
        companyDto.setAddress( company.getAddress() );

        return companyDto;
    }

    @Override
    public Company toMap(CompanyDto companyDto) {
        if ( companyDto == null ) {
            return null;
        }

        Company company = new Company();

        company.setWantedEmployeeList( wantedEmployeeDtoListToWantedEmployeeList( companyDto.getWantedEmployeeDtoList() ) );
        company.setRecruiters( recruitersDtoListToRecruitersList( companyDto.getRecruitersDtoList() ) );
        company.setId( companyDto.getId() );
        company.setName( companyDto.getName() );
        company.setNip( companyDto.getNip() );
        company.setAddress( companyDto.getAddress() );

        return company;
    }

    @Override
    public List<CompanyDto> toList(List<Company> list) {
        if ( list == null ) {
            return null;
        }

        List<CompanyDto> list1 = new ArrayList<CompanyDto>( list.size() );
        for ( Company company : list ) {
            list1.add( toDto( company ) );
        }

        return list1;
    }

    protected RecruitersDto recruitersToRecruitersDto(Recruiters recruiters) {
        if ( recruiters == null ) {
            return null;
        }

        RecruitersDtoBuilder recruitersDto = RecruitersDto.builder();

        recruitersDto.id( recruiters.getId() );
        recruitersDto.login( recruiters.getLogin() );
        recruitersDto.password( recruiters.getPassword() );
        recruitersDto.firstName( recruiters.getFirstName() );
        recruitersDto.lastName( recruiters.getLastName() );
        recruitersDto.phoneNumber( recruiters.getPhoneNumber() );
        recruitersDto.email( recruiters.getEmail() );

        return recruitersDto.build();
    }

    protected List<RecruitersDto> recruitersListToRecruitersDtoList(List<Recruiters> list) {
        if ( list == null ) {
            return null;
        }

        List<RecruitersDto> list1 = new ArrayList<RecruitersDto>( list.size() );
        for ( Recruiters recruiters : list ) {
            list1.add( recruitersToRecruitersDto( recruiters ) );
        }

        return list1;
    }

    protected WantedEmployee wantedEmployeeDtoToWantedEmployee(WantedEmployeeDto wantedEmployeeDto) {
        if ( wantedEmployeeDto == null ) {
            return null;
        }

        WantedEmployeeBuilder wantedEmployee = WantedEmployee.builder();

        wantedEmployee.id( wantedEmployeeDto.getId() );
        wantedEmployee.job( wantedEmployeeDto.getJob() );
        ArrayList<String> arrayList = wantedEmployeeDto.getRequirements();
        if ( arrayList != null ) {
            wantedEmployee.requirements( new ArrayList<String>( arrayList ) );
        }
        wantedEmployee.recruitmentStarts( wantedEmployeeDto.getRecruitmentStarts() );
        wantedEmployee.recruitmentEnds( wantedEmployeeDto.getRecruitmentEnds() );
        wantedEmployee.status( wantedEmployeeDto.getStatus() );

        return wantedEmployee.build();
    }

    protected List<WantedEmployee> wantedEmployeeDtoListToWantedEmployeeList(List<WantedEmployeeDto> list) {
        if ( list == null ) {
            return null;
        }

        List<WantedEmployee> list1 = new ArrayList<WantedEmployee>( list.size() );
        for ( WantedEmployeeDto wantedEmployeeDto : list ) {
            list1.add( wantedEmployeeDtoToWantedEmployee( wantedEmployeeDto ) );
        }

        return list1;
    }

    protected Recruiters recruitersDtoToRecruiters(RecruitersDto recruitersDto) {
        if ( recruitersDto == null ) {
            return null;
        }

        RecruitersBuilder recruiters = Recruiters.builder();

        recruiters.id( recruitersDto.getId() );
        recruiters.login( recruitersDto.getLogin() );
        recruiters.password( recruitersDto.getPassword() );
        recruiters.firstName( recruitersDto.getFirstName() );
        recruiters.lastName( recruitersDto.getLastName() );
        recruiters.phoneNumber( recruitersDto.getPhoneNumber() );
        recruiters.email( recruitersDto.getEmail() );

        return recruiters.build();
    }

    protected List<Recruiters> recruitersDtoListToRecruitersList(List<RecruitersDto> list) {
        if ( list == null ) {
            return null;
        }

        List<Recruiters> list1 = new ArrayList<Recruiters>( list.size() );
        for ( RecruitersDto recruitersDto : list ) {
            list1.add( recruitersDtoToRecruiters( recruitersDto ) );
        }

        return list1;
    }
}
