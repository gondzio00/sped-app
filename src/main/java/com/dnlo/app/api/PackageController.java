package com.dnlo.app.api;

import com.dnlo.app.PackageUpdate;
import com.dnlo.app.ReadDataHandler;
import com.dnlo.app.infrastructure.*;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/packages")
@AllArgsConstructor
@CrossOrigin(originPatterns = "*", maxAge = 3600, allowCredentials="true")
public class PackageController {

    private final PackageRepository packageRepository;
    private final PackageUpdatedRepository packageUpdatedRepository;
    private final ReadDataHandler readDataHandler;

    @GetMapping
    public ResponseEntity<List<PackageEntity>> getAll() {
        return ResponseEntity.ok(packageRepository.getAll());
    }

    @PostMapping("/upload")
    private void uploadFile(@RequestParam("file") MultipartFile file) {
        readDataHandler.uploadAndSavePackagesData(file);
    }

    @GetMapping("/{packageNumber}")
    private PackageAllData getPackageByPackageNumber(@PathVariable String packageNumber) {
        return packageRepository.findByPackageNumber(packageNumber);
    }

    @PostMapping("/updated/{packageNumber}")
    private void updatePackageData(@PathVariable("packageNumber") String packageNumber, @RequestBody PackageUpdate update) {
        packageUpdatedRepository.saveUpdatedPackageData(packageNumber, update);
    }

    @GetMapping("/updated/{packageNumber}")
    private Optional<PackageUpdatedData> getUpdatedData(@PathVariable String packageNumber) {
        return packageUpdatedRepository.getUpdatedPackageData(packageNumber);
    }

    @GetMapping("/get/{packageNumber}")
    @ResponseStatus(HttpStatus.OK)
    public List<PackageData> findByPackageNumber(@PathVariable("packageNumber") String packageNumber) {
        if (packageNumber.isEmpty()) {
            return readDataHandler.findAll();
        }

        return readDataHandler.findAllByPackageNumber(packageNumber);
    }
}
