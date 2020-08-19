//package com.hrsolutionsystem.hrss.model.mapper;
//
//import com.hrsolutionsystem.hrss.model.domain.dto.RecruitersDto;
//import com.hrsolutionsystem.hrss.model.domain.entity.Recruiters;
//import org.mapstruct.IterableMapping;
//import org.mapstruct.Mapper;
//import org.mapstruct.Named;
//import org.springframework.stereotype.Component;
//
//import java.util.List;
//
//@Component
//@Mapper(componentModel = "spring")
//public interface RecruitersMapper {
//    @Named("DtoToMap")
//    Recruiters toMap(RecruitersDto recruitersDto);
//    RecruitersDto toDto(Recruiters recruiters);
//
//    @IterableMapping(qualifiedByName = "DtoToMap")
//    List<RecruitersDto> toList(List<Recruiters> list);
//}
