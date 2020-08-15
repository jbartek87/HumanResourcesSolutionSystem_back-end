package com.hrsolutionsystem.hrss.model.service;

import com.hrsolutionsystem.hrss.exception.interview.InterviewNotFoundException;
import com.hrsolutionsystem.hrss.model.dao.InterviewDao;
import com.hrsolutionsystem.hrss.model.domain.dto.InterviewDto;
import com.hrsolutionsystem.hrss.model.domain.entity.CvDetails;
import com.hrsolutionsystem.hrss.model.domain.entity.Interview;
import com.hrsolutionsystem.hrss.model.mapper.InterviewMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class InterviewService {
    private InterviewMapper mapper;
    private InterviewDao repository;

    @Autowired
    public InterviewService(InterviewMapper mapper, InterviewDao repository) {
        this.mapper = mapper;
        this.repository = repository;
    }

    private InterviewNotFoundException notFound(Long id){
        return new InterviewNotFoundException(id);
    }

    public InterviewDto save(final InterviewDto interviewDto){
        Interview interview = repository.save(mapper.toMap(interviewDto));
        return mapper.toDto(interview);
    }

    public InterviewDto findById(final Long id){
        Optional<Interview> interview = repository.findById();
        return mapper.toDto(interview.orElseThrow(()->notFound(id)));
    }

    public void deleteById(final Long id){
        try{
            repository.deleteById(id);
        }catch (Exception e){
            throw notFound(id);
        }
    }
}
