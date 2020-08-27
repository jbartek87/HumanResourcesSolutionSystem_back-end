package com.hrsolutionsystem.hrss.model.service;

import com.hrsolutionsystem.hrss.exception.coverLetter.notfound.CoverLetterNotFoundException;
import com.hrsolutionsystem.hrss.exception.coverLetter.storage.CoverLetterStorageException;
import com.hrsolutionsystem.hrss.model.dao.CoverLetterDao;
import com.hrsolutionsystem.hrss.model.domain.entity.CoverLetter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class CoverLetterService {
    private CoverLetterDao repository;
    private Logger logger = LoggerFactory.getLogger(CoverLetterService.class);

    @Autowired
    public CoverLetterService(CoverLetterDao repository) {
        this.repository = repository;
    }

    private CoverLetterStorageException coverLetterStorageException(String message) {
        return new CoverLetterStorageException(message);
    }

    public void storeFile(MultipartFile file) {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        try {
            if (fileName.contains("..")) {
                throw coverLetterStorageException("Sorry! Filename contains invalid path sequence" + fileName);
            }
            CoverLetter coverLetter = new CoverLetter();
            coverLetter.setFileName(fileName);
            coverLetter.setFileType(file.getContentType());
            coverLetter.setFile(file.getBytes());
            logger.info("File: " + coverLetter.getFileName() + " type: " + coverLetter.getFileType() +
                    " size: " + coverLetter.getFile().length);

            repository.save(coverLetter);
        } catch (IOException e) {
            throw coverLetterStorageException("Couldn't store file: " + fileName + " Try again. " + e);
        }
    }

    public CoverLetter getFile(final String id) {
        return repository.findById(id).orElseThrow(() -> new CoverLetterNotFoundException(id));
    }

    public List<CoverLetter> getList() {
        return repository.findAll();
    }
}
