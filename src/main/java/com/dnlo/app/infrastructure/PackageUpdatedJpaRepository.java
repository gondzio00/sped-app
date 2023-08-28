package com.dnlo.app.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface PackageUpdatedJpaRepository extends JpaRepository<PackageUpdatedEntity, String> {

    @Query("SELECT pud FROM PackageUpdatedEntity pud WHERE pud.packageNumber = :packageNumber")
    Optional<PackageUpdatedData> findByPackageNumber(String packageNumber);
}
