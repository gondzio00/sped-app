package com.dnlo.app.infrastructure;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class PackageRepository {

    private final PackageJpaRepository packageJpaRepository;

    public void save(List<PackageEntity> packageEntities) {
        packageJpaRepository.saveAll(packageEntities);
    }

    public List<PackageData> findAllByPackageNumber(String packageNumber) {
        return packageJpaRepository.findAllByPackageNumberContaining(packageNumber);
    }

    public void deleteAll() {
        packageJpaRepository.deleteAll();
    }

    public PackageAllData findByPackageNumber(String packageNumber) {
        return packageJpaRepository.findByPackageNumberWithManipulationData(packageNumber)
                .orElseThrow(IllegalArgumentException::new);
    }

    public List<PackageData> findAll() {
        return packageJpaRepository.findAllData();
    }

}
