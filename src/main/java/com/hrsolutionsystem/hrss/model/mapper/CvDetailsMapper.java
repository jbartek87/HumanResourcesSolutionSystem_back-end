package com.hrsolutionsystem.hrss.model.mapper;

import com.hrsolutionsystem.hrss.model.domain.dto.CvDetailsDto;
import com.hrsolutionsystem.hrss.model.domain.entity.CvDetails;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface CvDetailsMapper {

    @Mappings({
            @Mapping(source = "letter.id", target = "coverLetterId"),
            @Mapping(source = "file.id", target = "cvFileId"),
            @Mapping(source = "recruiter.id", target = "recruiterId")
    })
    CvDetailsDto toDto(CvDetails cvDetails);

    @InheritInverseConfiguration
    CvDetails toMap(CvDetailsDto cvDetailsDto);
}
