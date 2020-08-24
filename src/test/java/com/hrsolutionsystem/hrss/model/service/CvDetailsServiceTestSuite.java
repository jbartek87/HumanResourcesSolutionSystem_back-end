package com.hrsolutionsystem.hrss.model.service;

import com.hrsolutionsystem.hrss.model.domain.dto.CvDetailsDto;
import com.hrsolutionsystem.hrss.model.domain.entity.CvFile;
import com.hrsolutionsystem.hrss.model.domain.enums.CvStatus;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest

public class CvDetailsServiceTestSuite {
    @Autowired
    private CvDetailsService service;

    @Test
    public void saveTest() {
        CvFile file = new CvFile();
        CvDetailsDto dto = new CvDetailsDto();
        dto.setApplyingPosition("Junior Developer Life Matters");
        dto.setEmail("kokoszka@o2.pl");
        dto.setFirstName("Kokosza");
        dto.setLastName("Pojoak");
        dto.setPhoneNumber(123123123L);
        dto.setStatus(CvStatus.HIRED);
        dto.setCoverLetterId(1L);
        dto.setRecruiterId(1L);
        dto.setCvFileId(1L);

        CvDetailsDto details = service.save(dto);


//        assertNotNull(details);
    }

//    @Test
//    public void findById() {
//        CvDetailsDto dto = new CvDetailsDto();
//        dto.setApplyingPosition("Junior Developer Life Matters");
//        dto.setCoverLetterId(1L);
//        dto.setCvFileId(1L);
//        dto.setEmail("kokoszka@o2.pl");
//        dto.setFirstName("Kokosza");
//        dto.setLastName("Pojoak");
//        dto.setPhoneNumber(123123123L);
//        dto.setStatus(CvStatus.HIRED);
//
//        CvDetailsDto details = service.save(dto);
//
//        id = details.getId();
//
//        assertNotNull(service.findById(id));
//    }
//
//    @Test(expected = CvDetailsNotFoundException.class)
//    public void notFound() {
//        Long notExistingId = 312312553L;
//        assertNull(service.findById(notExistingId));
//    }
}
