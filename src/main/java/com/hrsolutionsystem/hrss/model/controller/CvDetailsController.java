package com.hrsolutionsystem.hrss.model.controller;

import com.hrsolutionsystem.hrss.model.domain.dto.CvDetailsDto;
import com.hrsolutionsystem.hrss.model.service.CvDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/cvDetails")
@CrossOrigin("*")
public class CvDetailsController {
    private CvDetailsService service;

    @Autowired
    public CvDetailsController(CvDetailsService service) {
        this.service = service;
    }

    @PostMapping(value = "/create")
    public CvDetailsDto saveCvDetails(@RequestBody CvDetailsDto cvDetailsDto) {
       return service.save(cvDetailsDto);
    }

    @GetMapping(value = "/{id}")
    public CvDetailsDto findCvDetailsById(@PathVariable Long id) {
        return service.findById(id);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteCvDetailsById(@PathVariable Long id) {
        service.deleteById(id);
    }
}
