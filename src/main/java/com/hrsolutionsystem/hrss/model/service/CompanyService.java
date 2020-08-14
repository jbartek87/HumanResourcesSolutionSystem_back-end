package com.hrsolutionsystem.hrss.model.service;

import com.hrsolutionsystem.hrss.exception.company.CompanyNotFoundException;
import com.hrsolutionsystem.hrss.model.dao.CompanyDao;
import com.hrsolutionsystem.hrss.model.domain.dto.CompanyDto;
import com.hrsolutionsystem.hrss.model.domain.entity.Company;
import com.hrsolutionsystem.hrss.model.mapper.CompanyMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyService {
    private CompanyMapper mapper;
    private CompanyDao repository;
    private Logger logger = LoggerFactory.getLogger(CompanyService.class);

    @Autowired
    public CompanyService(CompanyMapper mapper, CompanyDao repository) {
        this.mapper = mapper;
        this.repository = repository;
    }

    private CompanyNotFoundException notFound(Long id) {
        return new CompanyNotFoundException(id);
    }

    public CompanyDto save(final CompanyDto companyDto) {
        Company company = repository.save(mapper.toMap(companyDto));
        logger.info("CREATED Company with ID: " + company.getId());

        return mapper.toDto(company);
    }

    public CompanyDto findById(final Long id) {
        Optional<Company> company = repository.findById(id);

        return mapper.toDto(company.orElseThrow(() -> notFound(id)));
    }

    public List<CompanyDto> getList() {
        return mapper.toList(repository.findAll());
    }

    public void deleteById(final Long id) {
        try {
            repository.deleteById(id);
            logger.info("DELETED Company with ID: " + id);
        } catch (Exception e) {
            logger.info("NOT FOUND Company with ID: " + id);
            throw notFound(id);
        }
    }

    public CompanyDto update(final CompanyDto companyDto) {
        Long id = companyDto.getId();
        Company company = repository.findById(id).orElseThrow(() -> notFound(id));
        logger.info("UPDATED Company with ID: " + id);

        return mapper.toDto(repository.save(mapper.toMap(companyDto)));
    }

}
