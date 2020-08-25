package com.hrsolutionsystem.hrss.model.dao;

import com.hrsolutionsystem.hrss.model.domain.entity.CoverLetter;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CoverLetterDao extends CrudRepository<CoverLetter, String> {

    @Override
    CoverLetter save(CoverLetter coverLetter);

    Optional<CoverLetter> findById(String id);
}
