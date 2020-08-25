package com.hrsolutionsystem.hrss.model.dao;

import com.hrsolutionsystem.hrss.model.domain.entity.CvFile;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CvFileDao extends CrudRepository<CvFile, String> {

    Optional<CvFile> findById(String id);

    @Override
    CvFile save(CvFile cvFile);
}
