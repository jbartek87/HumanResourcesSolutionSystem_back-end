package com.hrsolutionsystem.hrss.model.service;

import com.hrsolutionsystem.hrss.exception.cvFile.notfound.CvFileNotFoundException;
import com.hrsolutionsystem.hrss.exception.cvFile.storage.FileStorageException;
import com.hrsolutionsystem.hrss.model.dao.CvFileDao;
import com.hrsolutionsystem.hrss.model.domain.entity.CvFile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class CvFileService {
    private CvFileDao repository;
    private Logger logger = LoggerFactory.getLogger(CvFileService.class);

    @Autowired
    public CvFileService(CvFileDao repository) {
        this.repository = repository;
    }

    private FileStorageException fileStorageException(String message) {
        return new FileStorageException(message);
    }

    public void storeFile(MultipartFile file) {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        try {
            if (fileName.contains("..")) {
                throw fileStorageException("Sorry! Filename contains invalid path sequence" + fileName);
            }
            CvFile cvFile = new CvFile();
            cvFile.setFileName(fileName);
            cvFile.setFileType(file.getContentType());
            cvFile.setFile(file.getBytes());
            logger.info("File: " + cvFile.getFileName() + " type: " + cvFile.getFileType() +
                    " size: " + cvFile.getFile().length);

            repository.save(cvFile);

        } catch (IOException e) {
            throw fileStorageException("Couldn't store file: " + fileName + " Try again. " + e);
        }
    }

    public CvFile getFile(final String id) {
        return repository.findById(id).orElseThrow(() -> new CvFileNotFoundException((id)));
    }

    public List<CvFile> getFileList(){
        return repository.findAll();
    }
 }
