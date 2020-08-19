//package com.hrsolutionsystem.hrss.model.service;
//
//import com.hrsolutionsystem.hrss.exception.cvDetails.CvDetailsNotFoundException;
//import com.hrsolutionsystem.hrss.model.dao.CvDetailsDao;
//import com.hrsolutionsystem.hrss.model.domain.dto.CvDetailsDto;
//import com.hrsolutionsystem.hrss.model.domain.entity.CvDetails;
//import com.hrsolutionsystem.hrss.model.mapper.CvDetailsMapper;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.Optional;
//
//@Service
//public class CvDetailsService {
//    private CvDetailsMapper mapper;
//    private CvDetailsDao repository;
//    private Logger logger = LoggerFactory.getLogger(CvDetailsService.class);
//
//    @Autowired
//    public CvDetailsService(CvDetailsMapper mapper, CvDetailsDao repository) {
//        this.mapper = mapper;
//        this.repository = repository;
//    }
//
//    private CvDetailsNotFoundException notFound(Long id) {
//        return new CvDetailsNotFoundException(id);
//    }
//
//    public CvDetailsDto save(final CvDetailsDto cvDetailsDto) {
//        CvDetails cvDetails = repository.save(mapper.toMap(cvDetailsDto));
//
//        return mapper.toDto(cvDetails);
//    }
//
//    public CvDetailsDto findById(final Long id) {
//        Optional<CvDetails> cvDetails =  repository.findById(id);
//        return mapper.toDto(cvDetails.orElseThrow(() -> notFound(id)));
//    }
//
//    public void deleteById(final Long id) {
//        try {
//            repository.deleteById(id);
//            logger.info("DELETED CvDetails with ID: " + id);
//        } catch (Exception e) {
//            logger.warn("NOT FOUND CvDetails with ID: " + id);
//            throw notFound(id);
//        }
//    }
//}
