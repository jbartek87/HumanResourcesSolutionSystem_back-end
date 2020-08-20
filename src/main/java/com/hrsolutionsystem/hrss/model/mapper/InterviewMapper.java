package com.hrsolutionsystem.hrss.model.mapper;

import com.hrsolutionsystem.hrss.model.domain.dto.InterviewDto;
import com.hrsolutionsystem.hrss.model.domain.entity.Interview;
import org.mapstruct.*;
import org.springframework.stereotype.Component;


@Component
@Mapper(componentModel = "spring", uses = {RecruitersMapper.class})
public interface InterviewMapper {

    @Mappings({
            @Mapping(source = "recruiter.id", target = "recruiterId")
    })
    InterviewDto toDto(Interview interview);

    @Named("DtoToMap")
    @InheritInverseConfiguration
    Interview toMap(InterviewDto interviewDto);
}
