package com.dnlo.app.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface PackageJpaRepository extends JpaRepository<PackageEntity, String> {
    List<PackageData> findAllByPackageNumberContaining(String packageNumber);

    @Query("SELECT pe FROM PackageEntity pe join fetch pe.manipulationUnit dep where pe.packageNumber = :packageNumber")
    Optional<PackageAllData> findByPackageNumberWithManipulationData(String packageNumber);

    @Query("SELECT pe FROM PackageEntity pe")
    List<PackageData> findAllData();
}
