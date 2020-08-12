package com.hrsolutionsystem.hrss.model.mapper;

import com.hrsolutionsystem.hrss.model.domain.WantedEmployee;
import com.hrsolutionsystem.hrss.model.domain.WantedEmployeeDto;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Named;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper(componentModel = "spring")
public interface WantedEmployeeMapper {
    @Named("DtoToMap")
    WantedEmployee toMap(WantedEmployeeDto wantedEmployeeDto);
    WantedEmployeeDto toDto(WantedEmployee wantedEmployee);

    @IterableMapping(qualifiedByName = "DtoToMap")
    List<WantedEmployeeDto> toList(List<WantedEmployee> list);
}
