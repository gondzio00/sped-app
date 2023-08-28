package com.dnlo.app.api;

import com.dnlo.app.ReadDataHandler;
import com.dnlo.app.infrastructure.PackageRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/manipulation")
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowCredentials="true")
public class ManipulationDataController {

    private final ReadDataHandler readDataHandler;

    @PostMapping("/upload")
    private void uploadFile(@RequestParam("file") MultipartFile file) {
        readDataHandler.uploadAndSaveManipulationData(file);
    }
}
