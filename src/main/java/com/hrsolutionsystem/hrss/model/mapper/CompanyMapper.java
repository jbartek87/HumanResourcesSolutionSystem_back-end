package com.hrsolutionsystem.hrss.model.mapper;

import com.hrsolutionsystem.hrss.model.domain.dto.CompanyDto;
import com.hrsolutionsystem.hrss.model.domain.entity.Company;
import org.mapstruct.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper(componentModel = "spring")
public interface CompanyMapper {

    CompanyDto toDto(Company company);

    @Named("DtoToMap")
    Company toMap(CompanyDto companyDto);

    @IterableMapping(qualifiedByName = "DtoToMap")
    List<CompanyDto> toList(List<Company> list);
}
