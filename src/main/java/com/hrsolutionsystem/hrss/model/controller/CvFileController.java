package com.hrsolutionsystem.hrss.model.controller;

import com.hrsolutionsystem.hrss.model.domain.entity.CvFile;
import com.hrsolutionsystem.hrss.model.service.CvFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


@RestController
@RequestMapping("/v1/cvFile")
@CrossOrigin("*")
public class CvFileController {
    private CvFileService service;

    @Autowired
    public CvFileController(CvFileService service) {
        this.service = service;
    }

    @PostMapping(value = "/uploadFile", consumes = "application/pdf")
    public void uploadFile(@RequestParam("file")MultipartFile file) {
        service.storeFile(file);
    }

    @GetMapping(value = "/download/{id}")
    @Transactional
    public ResponseEntity<Resource> downloadFile(@PathVariable String id) {
        CvFile cvFile = service.getFile(id);

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(cvFile.getFileType()))
                .header("Content-Disposition", "attachment; filename="
                        + cvFile.getFileName().replaceAll("\\s+", "_"))
                .body(new ByteArrayResource(cvFile.getFile()));
    }
}
