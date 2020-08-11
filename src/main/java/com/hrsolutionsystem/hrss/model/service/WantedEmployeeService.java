package com.hrsolutionsystem.hrss.model.service;

import com.hrsolutionsystem.hrss.exception.wantedEmployee.WantedEmployeeNotFoundException;
import com.hrsolutionsystem.hrss.model.dao.WantedEmployeeDao;
import com.hrsolutionsystem.hrss.model.domain.WantedEmployee;
import com.hrsolutionsystem.hrss.model.domain.WantedEmployeeDto;
import com.hrsolutionsystem.hrss.model.mapper.WantedEmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WantedEmployeeService {
    private WantedEmployeeDao repository;
    private WantedEmployeeMapper mapper;

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
        repository.deleteById(id);
    }

    public WantedEmployeeDto wantedEmployeeSave(final WantedEmployeeDto wantedEmployeeDto) {
        WantedEmployee wantedEmployee = mapper.toMap(wantedEmployeeDto);
        mapper.toDto(repository.save(wantedEmployee));

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
