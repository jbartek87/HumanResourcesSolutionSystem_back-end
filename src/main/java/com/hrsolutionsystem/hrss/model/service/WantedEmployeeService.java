package com.hrsolutionsystem.hrss.model.service;

import com.hrsolutionsystem.hrss.exception.wantedEmployee.WantedEmployeeNotFoundException;
import com.hrsolutionsystem.hrss.model.dao.WantedEmployeeDao;
import com.hrsolutionsystem.hrss.model.domain.entity.WantedEmployee;
import com.hrsolutionsystem.hrss.model.domain.dto.WantedEmployeeDto;
import com.hrsolutionsystem.hrss.model.mapper.WantedEmployeeMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WantedEmployeeService {
    private WantedEmployeeDao repository;
    private WantedEmployeeMapper mapper;
    private Logger logger = LoggerFactory.getLogger(WantedEmployeeService.class);

    @Autowired
    public WantedEmployeeService(WantedEmployeeDao repository, WantedEmployeeMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    private WantedEmployeeNotFoundException notFoundException(Long id) {
        return new WantedEmployeeNotFoundException(id);
    }

    public WantedEmployeeDto wantedEmployeeFindById(final Long id) {
        Optional<WantedEmployee> wantedEmployee = repository.findById(id);
        return mapper.toDto(wantedEmployee.orElseThrow(() -> notFoundException(id)));
    }

    public List<WantedEmployeeDto> wantedEmployeeGetList() {
        return mapper.toList(repository.findAll());
    }

    public void wantedEmployeeDeleteById(final Long id) {
        try {
            repository.deleteById(id);
            logger.info("DELETED Wanted Employee with ID: " + id);
        } catch (Exception e) {
            logger.info("NOT FOUND Wanted Employee with ID: " + id);
            throw notFoundException(id);
        }
    }

    public WantedEmployeeDto wantedEmployeeSave(final WantedEmployeeDto wantedEmployeeDto) {
        WantedEmployee wantedEmployee = repository.save(mapper.toMap(wantedEmployeeDto));

        return mapper.toDto(wantedEmployee);
    }

    public WantedEmployeeDto wantedEmployeeUpdate(final WantedEmployeeDto wantedEmployeeDto) {
        Long id = wantedEmployeeDto.getId();
        WantedEmployee wantedEmployee = repository.findById(id).orElseThrow(() -> notFoundException(id));

        return mapper.toDto(repository.save(mapper.toMap(wantedEmployeeDto)));
    }

    public Long wantedEmployeeCount() {
        return repository.count();
    }
}
