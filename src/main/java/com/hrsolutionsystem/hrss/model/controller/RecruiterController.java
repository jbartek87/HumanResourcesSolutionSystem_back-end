package com.hrsolutionsystem.hrss.model.controller;

import com.hrsolutionsystem.hrss.model.domain.dto.RecruitersDto;
import com.hrsolutionsystem.hrss.model.service.RecruitersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/recruiter")
@CrossOrigin("*")
public class RecruiterController {

    private RecruitersService service;

    @Autowired
    public RecruiterController(RecruitersService service) {
        this.service = service;
    }

    @PostMapping(value = "/create")
    public RecruitersDto saveRecruiter(@RequestBody RecruitersDto recruitersDto){
        return service.save(recruitersDto);
    }

    @PostMapping(value = "/update")
    public RecruitersDto updateRecruiter(@RequestBody RecruitersDto recruitersDto){
        return service.update(recruitersDto);
    }

    @GetMapping(value = "/{id}")
    public RecruitersDto findRecruiterById(@PathVariable Long id){
        return service.findById(id);
    }

    @GetMapping(value = "/list")
    public List<RecruitersDto> getRecruiterList(){
        return service.recruitersGetList();
    }

    @DeleteMapping(value = "/{id}")
    public void deleteRecruiterById(@PathVariable Long id){
        service.deleteByID(id);
    }

}
