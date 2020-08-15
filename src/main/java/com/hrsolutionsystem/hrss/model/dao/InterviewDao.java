package com.hrsolutionsystem.hrss.model.dao;

import com.hrsolutionsystem.hrss.model.domain.entity.Interview;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface InterviewDao extends CrudRepository<Interview, Long> {

    @Override
    Optional<Interview> findById(Long id);

    @Override
    List<Interview> findAll();

    @Override
    void deleteById(Long id);

    @Override
    Interview save(Interview interview);
}
