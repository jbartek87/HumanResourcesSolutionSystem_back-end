package com.hrsolutionsystem.hrss.model.service;

import com.hrsolutionsystem.hrss.exception.recruiter.RecruitersNotFoundException;
import com.hrsolutionsystem.hrss.model.dao.RecruitersDao;
import com.hrsolutionsystem.hrss.model.domain.dto.RecruitersDto;
import com.hrsolutionsystem.hrss.model.domain.entity.Recruiters;
import com.hrsolutionsystem.hrss.model.mapper.RecruitersMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecruitersService {
    private RecruitersDao repository;
    private RecruitersMapper mapper;

    @Autowired
    public RecruitersService(RecruitersDao repository, RecruitersMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    private RecruitersNotFoundException notFoundException(Long id){
        return new RecruitersNotFoundException(id);
    }

    private RecruitersDto recruitersDtoFindById(final Long id){
        Optional<Recruiters> recruiter = repository.findById(id);
        return mapper.toDto(recruiter.orElseThrow(()-> notFoundException(id)));
    }

    private List<RecruitersDto> recruitersGetList(){
        return mapper.toList(repository.findAll());
    }

    private void recruitersDeleteByID(final Long id){
        repository.deleteById(id);
    }

    private RecruitersDto recruitersSave(final RecruitersDto recruitersDto){
        Recruiters recruiter = mapper.toMap(recruitersDto);
        mapper.toDto(repository.save(recruiter));

        return mapper.toDto(recruiter);
    }

    private RecruitersDto recruitersUpdate(final RecruitersDto recruitersDto){
        Long id = recruitersDto.getId();
        Recruiters recruiter = repository.findById(id).orElseThrow(()->notFoundException(id));
        return mapper.toDto(repository.save(mapper.toMap(recruitersDto)));

    }
}
