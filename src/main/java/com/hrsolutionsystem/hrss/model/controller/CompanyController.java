package com.hrsolutionsystem.hrss.model.controller;

import com.hrsolutionsystem.hrss.model.domain.dto.CompanyDto;
import com.hrsolutionsystem.hrss.model.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/company")
@CrossOrigin("*")
public class CompanyController {
    private CompanyService service;

    @Autowired
    public CompanyController(CompanyService service) {
        this.service = service;
    }

    @PostMapping(value = "/create")
    public CompanyDto companySave(@RequestBody CompanyDto companyDto) {
        return service.save(companyDto);
    }

    @GetMapping(value = "/{id}")
    public CompanyDto companyFindById(@PathVariable Long id) {
        return service.findById(id);
    }

    @GetMapping(value = "/list")
    public List<CompanyDto> companyList() {
        return service.getList();
    }

    @DeleteMapping(value = "/{id}")
    public void companyDeleteById(@PathVariable Long id) {
        service.deleteById(id);
    }

    @PutMapping(value = "/update")
    public CompanyDto companyUpdate(@RequestBody CompanyDto companyDto) {
        return service.update(companyDto);
    }
}
