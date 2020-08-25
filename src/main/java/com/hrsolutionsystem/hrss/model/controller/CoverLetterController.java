package com.hrsolutionsystem.hrss.model.controller;

import com.hrsolutionsystem.hrss.exception.coverLetter.storage.CoverLetterStorageException;
import com.hrsolutionsystem.hrss.model.domain.entity.CoverLetter;
import com.hrsolutionsystem.hrss.model.service.CoverLetterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/v1/coverLetter")
@CrossOrigin("*")
public class CoverLetterController {
    private CoverLetterService service;

    @Autowired
    public CoverLetterController(CoverLetterService service) {
        this.service = service;
    }

    @PostMapping(value = "/uploadFile", consumes = {"multipart/form-data", "application/msword"})
    public void uploadFile(@RequestParam("file") MultipartFile file) {
        if (file.getContentType().equals("application/msword")) {
            service.storeFile(file);
        } else {
            throw new CoverLetterStorageException("Unsupported format!");
        }
    }

    @GetMapping(value = "/download/{id}")
    @Transactional
    public ResponseEntity<Resource> downloadFile(@PathVariable String id) {
        CoverLetter coverLetter = service.getFile(id);

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(coverLetter.getFileType()))
                .header("Content-Disposition", "attachment; filename="
                        + coverLetter.getFileName().replaceAll("\\s+", "_"))
                .body(new ByteArrayResource(coverLetter.getFile()));
    }
}
