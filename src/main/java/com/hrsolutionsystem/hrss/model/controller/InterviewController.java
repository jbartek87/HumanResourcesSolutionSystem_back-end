package com.hrsolutionsystem.hrss.model.controller;

import com.hrsolutionsystem.hrss.model.domain.dto.InterviewDto;
import com.hrsolutionsystem.hrss.model.service.InterviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/interviews")
@CrossOrigin("*")
public class InterviewController {
    private InterviewService service;

    @Autowired
    public InterviewController(InterviewService service) {
        this.service = service;
    }

    @PostMapping(value = "/create")
    public InterviewDto save(InterviewDto interviewDto) {
        return service.save(interviewDto);
    }

    @GetMapping("/{id}")
    public InterviewDto findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        service.deleteById(id);
    }
}
