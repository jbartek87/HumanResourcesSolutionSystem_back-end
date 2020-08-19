//package com.hrsolutionsystem.hrss.model.controller;
//
//import com.hrsolutionsystem.hrss.model.domain.dto.WantedEmployeeDto;
//import com.hrsolutionsystem.hrss.model.service.WantedEmployeeService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/v1/wantedEmployee")
//public class WantedEmployeeController {
//    private WantedEmployeeService service;
//
//    @Autowired
//    public WantedEmployeeController(WantedEmployeeService service) {
//        this.service = service;
//    }
//
//    @GetMapping(value = "/{id}")
//    public WantedEmployeeDto getById(@PathVariable Long id) {
//        return service.wantedEmployeeFindById(id);
//    }
//
//    @GetMapping(value = "/list")
//    public List<WantedEmployeeDto> getList() {
//        return service.wantedEmployeeGetList();
//    }
//
//    @DeleteMapping(value = "/{id}")
//    public void deleteById(@PathVariable Long id) {
//        service.wantedEmployeeDeleteById(id);
//    }
//
//    @PostMapping(value = "/create")
//    public WantedEmployeeDto save(@RequestBody WantedEmployeeDto wantedEmployeeDto) {
//        return service.wantedEmployeeSave(wantedEmployeeDto);
//    }
//
//    @PutMapping(value = "/update")
//    public WantedEmployeeDto update(@RequestBody WantedEmployeeDto wantedEmployeeDto) {
//        return service.wantedEmployeeUpdate(wantedEmployeeDto);
//    }
//
//    @GetMapping(value = "/count")
//    public Long count() {
//        return service.wantedEmployeeCount();
//    }
//}
