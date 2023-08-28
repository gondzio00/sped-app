package com.dnlo.app;

import com.dnlo.app.infrastructure.ManipulationUnitEntity;
import com.dnlo.app.infrastructure.PackageData;
import com.dnlo.app.infrastructure.PackageEntity;
import com.dnlo.app.infrastructure.PackageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReadDataHandler {

    private final ExcelReader excelReader;
    private final ExcelDataMapper excelDataMapper;
    private final ExcelManipulationDataMapper excelManipulationDataMapper;
    private final SaveDataHandler saveDataHandler;
    private final PackageRepository packageRepository;

    public List<PackageData> findAllByPackageNumber(String packageNumber) {
        return packageRepository.findAllByPackageNumber(packageNumber);
    }

    public List<PackageData> findAll() {
        return packageRepository.findAll();
    }

    public void uploadAndSavePackagesData(MultipartFile file) {
        try {
            List<ExcelData> excelDataList = excelReader.readPackagesFile(file);

            List<PackageEntity> packages = excelDataMapper.toPackagesEntities(excelDataList);
            saveDataHandler.overidePackagesData(packages);
        } catch (Throwable ignored) {
            throw new IllegalStateException(ignored);
        }
    }

    public void uploadAndSaveManipulationData(MultipartFile file) {
        try {
            List<ManipulationUnitExcelData> excelDataList = excelReader.readManipulationFile(file);

            List<ManipulationUnitEntity> manipulationUnitEntities = excelManipulationDataMapper.toManipulationDataEntities(excelDataList);
            saveDataHandler.overideManipulationData(manipulationUnitEntities);
        } catch (Throwable ignored) {
            throw new IllegalStateException(ignored);
        }
    }
}
