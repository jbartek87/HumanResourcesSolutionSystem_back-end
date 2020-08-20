package com.hrsolutionsystem.hrss.model.mapper;

import com.hrsolutionsystem.hrss.model.domain.dto.WantedEmployeeDto;
import com.hrsolutionsystem.hrss.model.domain.dto.WantedEmployeeDto.WantedEmployeeDtoBuilder;
import com.hrsolutionsystem.hrss.model.domain.entity.Company;
import com.hrsolutionsystem.hrss.model.domain.entity.WantedEmployee;
import com.hrsolutionsystem.hrss.model.domain.entity.WantedEmployee.WantedEmployeeBuilder;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-08-20T09:29:04+0200",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 1.8.0_261 (Oracle Corporation)"
)
@Component
public class WantedEmployeeMapperImpl implements WantedEmployeeMapper {

    @Override
    public WantedEmployeeDto toDto(WantedEmployee wantedEmployee) {
        if ( wantedEmployee == null ) {
            return null;
        }

        WantedEmployeeDtoBuilder wantedEmployeeDto = WantedEmployeeDto.builder();

        wantedEmployeeDto.companyId( wantedEmployeeCompanyId( wantedEmployee ) );
        wantedEmployeeDto.id( wantedEmployee.getId() );
        wantedEmployeeDto.job( wantedEmployee.getJob() );
        ArrayList<String> arrayList = wantedEmployee.getRequirements();
        if ( arrayList != null ) {
            wantedEmployeeDto.requirements( new ArrayList<String>( arrayList ) );
        }
        wantedEmployeeDto.recruitmentStarts( wantedEmployee.getRecruitmentStarts() );
        wantedEmployeeDto.recruitmentEnds( wantedEmployee.getRecruitmentEnds() );
        wantedEmployeeDto.status( wantedEmployee.getStatus() );

        return wantedEmployeeDto.build();
    }

    @Override
    public WantedEmployee toMap(WantedEmployeeDto wantedEmployeeDto) {
        if ( wantedEmployeeDto == null ) {
            return null;
        }

        WantedEmployeeBuilder wantedEmployee = WantedEmployee.builder();

        wantedEmployee.company( wantedEmployeeDtoToCompany( wantedEmployeeDto ) );
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

    @Override
    public List<WantedEmployeeDto> toList(List<WantedEmployee> list) {
        if ( list == null ) {
            return null;
        }

        List<WantedEmployeeDto> list1 = new ArrayList<WantedEmployeeDto>( list.size() );
        for ( WantedEmployee wantedEmployee : list ) {
            list1.add( toDto( wantedEmployee ) );
        }

        return list1;
    }

    private Long wantedEmployeeCompanyId(WantedEmployee wantedEmployee) {
        if ( wantedEmployee == null ) {
            return null;
        }
        Company company = wantedEmployee.getCompany();
        if ( company == null ) {
            return null;
        }
        Long id = company.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    protected Company wantedEmployeeDtoToCompany(WantedEmployeeDto wantedEmployeeDto) {
        if ( wantedEmployeeDto == null ) {
            return null;
        }

        Company company = new Company();

        company.setId( wantedEmployeeDto.getCompanyId() );

        return company;
    }
}
