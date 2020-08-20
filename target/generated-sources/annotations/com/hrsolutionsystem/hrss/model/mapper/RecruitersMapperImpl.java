package com.hrsolutionsystem.hrss.model.mapper;

import com.hrsolutionsystem.hrss.model.domain.dto.RecruitersDto;
import com.hrsolutionsystem.hrss.model.domain.dto.RecruitersDto.RecruitersDtoBuilder;
import com.hrsolutionsystem.hrss.model.domain.entity.Recruiters;
import com.hrsolutionsystem.hrss.model.domain.entity.Recruiters.RecruitersBuilder;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-08-20T20:11:32+0200",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 1.8.0_261 (Oracle Corporation)"
)
@Component
public class RecruitersMapperImpl implements RecruitersMapper {

    @Override
    public RecruitersDto toDto(Recruiters recruiters) {
        if ( recruiters == null ) {
            return null;
        }

        RecruitersDtoBuilder recruitersDto = RecruitersDto.builder();

        recruitersDto.id( recruiters.getId() );
        recruitersDto.login( recruiters.getLogin() );
        recruitersDto.password( recruiters.getPassword() );
        recruitersDto.firstName( recruiters.getFirstName() );
        recruitersDto.lastName( recruiters.getLastName() );
        recruitersDto.phoneNumber( recruiters.getPhoneNumber() );
        recruitersDto.email( recruiters.getEmail() );

        return recruitersDto.build();
    }

    @Override
    public Recruiters toMap(RecruitersDto recruitersDto) {
        if ( recruitersDto == null ) {
            return null;
        }

        RecruitersBuilder recruiters = Recruiters.builder();

        recruiters.id( recruitersDto.getId() );
        recruiters.login( recruitersDto.getLogin() );
        recruiters.password( recruitersDto.getPassword() );
        recruiters.firstName( recruitersDto.getFirstName() );
        recruiters.lastName( recruitersDto.getLastName() );
        recruiters.phoneNumber( recruitersDto.getPhoneNumber() );
        recruiters.email( recruitersDto.getEmail() );

        return recruiters.build();
    }

    @Override
    public List<RecruitersDto> toList(List<Recruiters> list) {
        if ( list == null ) {
            return null;
        }

        List<RecruitersDto> list1 = new ArrayList<RecruitersDto>( list.size() );
        for ( Recruiters recruiters : list ) {
            list1.add( toDto( recruiters ) );
        }

        return list1;
    }
}
