//package com.hrsolutionsystem.hrss.model.mapper;
//
//import com.hrsolutionsystem.hrss.model.domain.dto.CompanyDto;
//import com.hrsolutionsystem.hrss.model.domain.entity.Company;
//import org.mapstruct.IterableMapping;
//import org.mapstruct.Mapper;
//import org.mapstruct.Named;
//import org.springframework.stereotype.Component;
//
//import java.util.List;
//
//@Component
//@Mapper(componentModel = "spring")
//public interface CompanyMapper {
//    @Named("DtoToMap")
//    Company toMap(CompanyDto companyDto);
//    CompanyDto toDto(Company company);
//
//    @IterableMapping(qualifiedByName = "DtoToMap")
//    List<CompanyDto> toList(List<Company> list);
//}
