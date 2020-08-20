package com.hrsolutionsystem.hrss.model.mapper;

import com.hrsolutionsystem.hrss.model.domain.dto.CvDetailsDto;
import com.hrsolutionsystem.hrss.model.domain.dto.CvDetailsDto.CvDetailsDtoBuilder;
import com.hrsolutionsystem.hrss.model.domain.entity.CoverLetter;
import com.hrsolutionsystem.hrss.model.domain.entity.CvDetails;
import com.hrsolutionsystem.hrss.model.domain.entity.CvDetails.CvDetailsBuilder;
import com.hrsolutionsystem.hrss.model.domain.entity.CvFile;
import com.hrsolutionsystem.hrss.model.domain.entity.Recruiters;
import com.hrsolutionsystem.hrss.model.domain.entity.Recruiters.RecruitersBuilder;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-08-20T20:11:32+0200",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 1.8.0_261 (Oracle Corporation)"
)
@Component
public class CvDetailsMapperImpl implements CvDetailsMapper {

    @Override
    public CvDetailsDto toDto(CvDetails cvDetails) {
        if ( cvDetails == null ) {
            return null;
        }

        CvDetailsDtoBuilder cvDetailsDto = CvDetailsDto.builder();

        cvDetailsDto.recruiterId( cvDetailsRecruiterId( cvDetails ) );
        cvDetailsDto.coverLetterId( cvDetailsLetterId( cvDetails ) );
        cvDetailsDto.cvFileId( cvDetailsFileId( cvDetails ) );
        cvDetailsDto.id( cvDetails.getId() );
        cvDetailsDto.applyingPosition( cvDetails.getApplyingPosition() );
        cvDetailsDto.firstName( cvDetails.getFirstName() );
        cvDetailsDto.lastName( cvDetails.getLastName() );
        cvDetailsDto.phoneNumber( cvDetails.getPhoneNumber() );
        cvDetailsDto.email( cvDetails.getEmail() );
        cvDetailsDto.status( cvDetails.getStatus() );

        return cvDetailsDto.build();
    }

    @Override
    public CvDetails toMap(CvDetailsDto cvDetailsDto) {
        if ( cvDetailsDto == null ) {
            return null;
        }

        CvDetailsBuilder cvDetails = CvDetails.builder();

        cvDetails.file( cvDetailsDtoToCvFile( cvDetailsDto ) );
        cvDetails.recruiter( cvDetailsDtoToRecruiters( cvDetailsDto ) );
        cvDetails.letter( cvDetailsDtoToCoverLetter( cvDetailsDto ) );
        cvDetails.id( cvDetailsDto.getId() );
        cvDetails.applyingPosition( cvDetailsDto.getApplyingPosition() );
        cvDetails.firstName( cvDetailsDto.getFirstName() );
        cvDetails.lastName( cvDetailsDto.getLastName() );
        cvDetails.phoneNumber( cvDetailsDto.getPhoneNumber() );
        cvDetails.email( cvDetailsDto.getEmail() );
        cvDetails.status( cvDetailsDto.getStatus() );

        return cvDetails.build();
    }

    private Long cvDetailsRecruiterId(CvDetails cvDetails) {
        if ( cvDetails == null ) {
            return null;
        }
        Recruiters recruiter = cvDetails.getRecruiter();
        if ( recruiter == null ) {
            return null;
        }
        Long id = recruiter.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private Long cvDetailsLetterId(CvDetails cvDetails) {
        if ( cvDetails == null ) {
            return null;
        }
        CoverLetter letter = cvDetails.getLetter();
        if ( letter == null ) {
            return null;
        }
        Long id = letter.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private Long cvDetailsFileId(CvDetails cvDetails) {
        if ( cvDetails == null ) {
            return null;
        }
        CvFile file = cvDetails.getFile();
        if ( file == null ) {
            return null;
        }
        Long id = file.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    protected CvFile cvDetailsDtoToCvFile(CvDetailsDto cvDetailsDto) {
        if ( cvDetailsDto == null ) {
            return null;
        }

        CvFile cvFile = new CvFile();

        cvFile.setId( cvDetailsDto.getCvFileId() );

        return cvFile;
    }

    protected Recruiters cvDetailsDtoToRecruiters(CvDetailsDto cvDetailsDto) {
        if ( cvDetailsDto == null ) {
            return null;
        }

        RecruitersBuilder recruiters = Recruiters.builder();

        recruiters.id( cvDetailsDto.getRecruiterId() );

        return recruiters.build();
    }

    protected CoverLetter cvDetailsDtoToCoverLetter(CvDetailsDto cvDetailsDto) {
        if ( cvDetailsDto == null ) {
            return null;
        }

        CoverLetter coverLetter = new CoverLetter();

        coverLetter.setId( cvDetailsDto.getCoverLetterId() );

        return coverLetter;
    }
}
