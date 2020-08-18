package com.hrsolutionsystem.hrss.model.dao;

import com.hrsolutionsystem.hrss.model.domain.entity.Company;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CompanyDao extends CrudRepository<Company, Long> {
    @Override
    Company save(Company company);

    @Override
    Optional<Company> findById(Long id);

    @Override
    List<Company> findAll();

    @Override
    void deleteById(Long id);
}
