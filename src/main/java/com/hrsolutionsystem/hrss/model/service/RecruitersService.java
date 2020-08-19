//package com.hrsolutionsystem.hrss.model.service;
//
//import com.hrsolutionsystem.hrss.exception.recruiter.RecruitersNotFoundException;
//import com.hrsolutionsystem.hrss.model.dao.RecruitersDao;
//import com.hrsolutionsystem.hrss.model.domain.dto.RecruitersDto;
//import com.hrsolutionsystem.hrss.model.domain.entity.Recruiters;
//import com.hrsolutionsystem.hrss.model.mapper.RecruitersMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class RecruitersService {
//    private RecruitersDao repository;
//    private RecruitersMapper mapper;
//
//    @Autowired
//    public RecruitersService(RecruitersDao repository, RecruitersMapper mapper) {
//        this.repository = repository;
//        this.mapper = mapper;
//    }
//
//    private RecruitersNotFoundException notFoundException(Long id){
//        return new RecruitersNotFoundException(id);
//    }
//
//    public RecruitersDto findById(final Long id){
//        Optional<Recruiters> recruiter = repository.findById(id);
//        return mapper.toDto(recruiter.orElseThrow(()-> notFoundException(id)));
//    }
//
//    public List<RecruitersDto> recruitersGetList(){
//        return mapper.toList(repository.findAll());
//    }
//
//    public void deleteByID(final Long id){
//        repository.deleteById(id);
//    }
//
//    public RecruitersDto save(final RecruitersDto recruitersDto){
//        Recruiters recruiter = mapper.toMap(recruitersDto);
//        mapper.toDto(repository.save(recruiter));
//
//        return mapper.toDto(recruiter);
//    }
//
//    public RecruitersDto update(final RecruitersDto recruitersDto){
//        Long id = recruitersDto.getId();
//        Recruiters recruiter = repository.findById(id).orElseThrow(()->notFoundException(id));
//        return mapper.toDto(repository.save(mapper.toMap(recruitersDto)));
//
//    }
//}
