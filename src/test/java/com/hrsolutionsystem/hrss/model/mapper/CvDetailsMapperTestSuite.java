package com.hrsolutionsystem.hrss.model.mapper;

import com.hrsolutionsystem.hrss.model.domain.dto.CvDetailsDto;
import com.hrsolutionsystem.hrss.model.domain.entity.CoverLetter;
import com.hrsolutionsystem.hrss.model.domain.entity.CvDetails;
import com.hrsolutionsystem.hrss.model.domain.entity.CvFile;
import com.hrsolutionsystem.hrss.model.domain.enums.CvStatus;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CvDetailsMapperTestSuite {
    private CvDetailsMapper mapper = new CvDetailsMapperImpl();

    @Test
    public void toMapTest() {
        //Given
        CvDetailsDto dto = new CvDetailsDto();
        dto.setId(1L);
        dto.setApplyingPosition("Junior Developer Life Matters");
        dto.setCoverLetterId(1L);
        dto.setCvFileId(1L);
        dto.setEmail("kokoszka@o2.pl");
        dto.setFirstName("Kokosza");
        dto.setLastName("Pojoak");
        dto.setPhoneNumber(123123123L);
        dto.setStatus(CvStatus.HIRED);
        //When
        CvDetails cvDetails = mapper.toMap(dto);
        //Then
        assertEquals(cvDetails.getId(), dto.getId());
        assertEquals(cvDetails.getApplyingPosition(), dto.getApplyingPosition());
        assertEquals(cvDetails.getLetter().getId(), dto.getCoverLetterId());
        assertEquals(cvDetails.getFile().getId(), dto.getCvFileId());
        assertEquals(cvDetails.getEmail(), dto.getEmail());
        assertEquals(cvDetails.getFirstName(), dto.getFirstName());
        assertEquals(cvDetails.getLastName(), dto.getLastName());
        assertEquals(cvDetails.getStatus(), dto.getStatus());
    }

    @Test
    public void toDtoTest() {
        //Given
        byte[] mylist = new byte[]{1,2,3,4};
        CvFile cvFile = new CvFile();
        cvFile.setFile(mylist);
        cvFile.setFileName("ddd");
        cvFile.setFileType("ddd");
        CoverLetter coverLetter = new CoverLetter(1L, mylist, "xxx", "fff");
        CvDetails map = new CvDetails();
        map.setId(1L);
        map.setApplyingPosition("Junior Developer Life Matters");
        map.setFile(cvFile);
        map.setLetter(coverLetter);
        map.setEmail("kokoszka@o2.pl");
        map.setFirstName("Kokosza");
        map.setLastName("Pojoak");
        map.setPhoneNumber(123123123L);
        map.setStatus(CvStatus.HIRED);
        //When
        CvDetailsDto cvDetailsDto = mapper.toDto(map);
        //Then
        assertEquals(cvDetailsDto.getId(), map.getId());
        assertEquals(cvDetailsDto.getApplyingPosition(), map.getApplyingPosition());
        assertEquals(cvDetailsDto.getCoverLetterId(), map.getLetter().getId());
        assertEquals(cvDetailsDto.getCvFileId(), map.getFile().getId());
        assertEquals(cvDetailsDto.getEmail(), map.getEmail());
        assertEquals(cvDetailsDto.getFirstName(), map.getFirstName());
        assertEquals(cvDetailsDto.getLastName(), map.getLastName());
        assertEquals(cvDetailsDto.getStatus(), map.getStatus());
    }
}
