package com.hrsolutionsystem.hrss.model.mapper;

import com.hrsolutionsystem.hrss.model.domain.entity.WantedEmployee;
import com.hrsolutionsystem.hrss.model.domain.dto.WantedEmployeeDto;
import org.mapstruct.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper(componentModel = "spring")
public interface WantedEmployeeMapper {
    @Mappings({
            @Mapping(source = "company.id", target = "companyId")
    })
    WantedEmployeeDto toDto(WantedEmployee wantedEmployee);

    @Named("DtoToMap")
    @InheritInverseConfiguration
    WantedEmployee toMap(WantedEmployeeDto wantedEmployeeDto);

    @IterableMapping(qualifiedByName = "DtoToMap")
    List<WantedEmployeeDto> toList(List<WantedEmployee> list);
}
