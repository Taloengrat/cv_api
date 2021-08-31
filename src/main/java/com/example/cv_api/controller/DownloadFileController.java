package com.example.cv_api.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;

import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DownloadFileController {

    @GetMapping("/download-cv")
    public ResponseEntity<InputStreamResource> download() throws IOException {

        File file = new File("/usr/src/myapp/taloengrat_cv.pdf");

        InputStreamResource resource = new InputStreamResource(new FileInputStream(file));

        return ResponseEntity.ok().contentType(MediaType.IMAGE_PNG)
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getName() + "\"")
                .contentLength(file.length()).body(resource);
    }

    @GetMapping("/show-cv")
    public ResponseEntity<byte[]> getImage() throws IOException {
        File img = new File("/usr/src/myapp/taloengrat_cv.pdf");
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_PDF).body(Files.readAllBytes(img.toPath()));
    }

    @RequestMapping(value = "/")
    public String requestMethodName() {
        return "CV-API is Activated";
    }
}
