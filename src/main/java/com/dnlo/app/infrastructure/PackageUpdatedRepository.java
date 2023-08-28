package com.dnlo.app.infrastructure;

import com.dnlo.app.PackageUpdate;
import com.dnlo.app.PackageUpdateMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@AllArgsConstructor
public class PackageUpdatedRepository {

    private final PackageUpdatedJpaRepository packageUpdatedJpaRepository;
    private final PackageUpdateMapper packageUpdateMapper;

    public void saveUpdatedPackageData(String packageNumber, PackageUpdate update) {
        var updated = packageUpdateMapper.toPackageUpdatedEntity(update);

        packageUpdatedJpaRepository.save(updated);

    }

    public Optional<PackageUpdatedData> getUpdatedPackageData(String packageNumber) {
        return packageUpdatedJpaRepository.findByPackageNumber(packageNumber);
    }
}
