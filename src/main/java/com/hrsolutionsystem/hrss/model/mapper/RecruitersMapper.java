package com.hrsolutionsystem.hrss.model.mapper;

import com.hrsolutionsystem.hrss.model.domain.dto.RecruitersDto;
import com.hrsolutionsystem.hrss.model.domain.entity.Recruiters;
import org.mapstruct.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper(componentModel = "spring")
public interface RecruitersMapper {
    RecruitersDto toDto(Recruiters recruiters);

    @Named("DtoToMap")
    Recruiters toMap(RecruitersDto recruitersDto);

    @IterableMapping(qualifiedByName = "DtoToMap")
    List<RecruitersDto> toList(List<Recruiters> list);
}
