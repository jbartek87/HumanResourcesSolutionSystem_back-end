package com.hrsolutionsystem.hrss.model.dao;

import com.hrsolutionsystem.hrss.model.domain.entity.CvDetails;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CvDetailsDao extends CrudRepository<CvDetails, Long> {

    @Override
    CvDetails save(CvDetails cvDetails);

    @Override
    Optional<CvDetails> findById(Long id);

    @Override
    void deleteById(Long id);
}
