package com.hrsolutionsystem.hrss.model.mapper;

import com.hrsolutionsystem.hrss.model.domain.dto.CompanyDto;
import com.hrsolutionsystem.hrss.model.domain.entity.Company;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-08-20T20:11:32+0200",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 1.8.0_261 (Oracle Corporation)"
)
@Component
public class CompanyMapperImpl implements CompanyMapper {

    @Override
    public CompanyDto toDto(Company company) {
        if ( company == null ) {
            return null;
        }

        CompanyDto companyDto = new CompanyDto();

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
}
