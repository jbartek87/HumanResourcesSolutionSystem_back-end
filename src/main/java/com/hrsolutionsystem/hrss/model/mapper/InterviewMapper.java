package com.hrsolutionsystem.hrss.model.mapper;

import com.hrsolutionsystem.hrss.model.domain.dto.InterviewDto;
import com.hrsolutionsystem.hrss.model.domain.entity.Interview;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Named;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper(componentModel = "spring")
public interface InterviewMapper {
    @Named("DtoToMap")
    Interview toMap(InterviewDto interviewDto);
    InterviewDto toDto(Interview interview);

    @IterableMapping(qualifiedByName = "DtoToMap")
    List<InterviewDto> toList(List<Interview> list);
}
