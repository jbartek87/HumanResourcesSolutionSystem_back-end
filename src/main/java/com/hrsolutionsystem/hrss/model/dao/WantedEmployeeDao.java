package com.hrsolutionsystem.hrss.model.dao;

import com.hrsolutionsystem.hrss.model.domain.entity.WantedEmployee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface WantedEmployeeDao extends CrudRepository<WantedEmployee, Long> {
    @Override
    Optional<WantedEmployee> findById(Long id);

    @Override
    List<WantedEmployee> findAll();

    @Override
    void deleteById(Long id);

    @Override
    WantedEmployee save(WantedEmployee wantedEmployee);

    @Override
    long count();
}
