package com.hrsolutionsystem.hrss.model.mapper;

import com.hrsolutionsystem.hrss.model.domain.dto.RecruitersDto;
import com.hrsolutionsystem.hrss.model.domain.entity.Recruiters;
import org.mapstruct.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper(componentModel = "spring", uses = {CompanyMapper.class})
public interface RecruitersMapper {

    @Mappings({
            @Mapping(source = "interviewList", target = "interviewDtoList"),
            @Mapping(source = "cvDetailsList", target = "cvDetailsDtoList"),
            @Mapping(source = "companies", target = "companyDtoList")
    })
    RecruitersDto toDto(Recruiters recruiters);


    @Named("DtoToMap")
    @InheritInverseConfiguration
    Recruiters toMap(RecruitersDto recruitersDto);

    @IterableMapping(qualifiedByName = "DtoToMap")
    List<RecruitersDto> toList(List<Recruiters> list);
}
