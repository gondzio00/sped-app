package com.dnlo.app;

import com.dnlo.app.infrastructure.ManipulationUnitEntity;
import com.dnlo.app.infrastructure.ManipulationUnitRepository;
import com.dnlo.app.infrastructure.PackageEntity;
import com.dnlo.app.infrastructure.PackageRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SaveDataHandler {

    private final PackageRepository packageRepository;
    private final ManipulationUnitRepository manipulationUnitRepository;

    @Transactional
    public void overidePackagesData(List<PackageEntity> packages) {
        packageRepository.deleteAll();

        for (PackageEntity packageEntity: packages) {
            manipulationUnitRepository.findByCode(packageEntity.getManipulationUnit().getCode())
                    .ifPresent(packageEntity::setManipulationUnit);

        }

        packageRepository.save(packages);
    }

    @Transactional
    public void overideManipulationData(List<ManipulationUnitEntity> manipulationData) {
        manipulationUnitRepository.deleteAll();
        manipulationUnitRepository.save(manipulationData);
    }
}
