package com.dnlo.app.infrastructure;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@AllArgsConstructor
public class ManipulationUnitRepository {

    private final ManipulationUnitJpaRepository manipulationUnitJpaRepository;

    public List<ManipulationUnitEntity> findALl() {
        return manipulationUnitJpaRepository.findAll();
    }

    public Optional<ManipulationUnitEntity> findByCode(String code) {
        return manipulationUnitJpaRepository.findById(code);
    }

    public void save(List<ManipulationUnitEntity> manipulationUnitEntities) {
        manipulationUnitJpaRepository.saveAll(manipulationUnitEntities);
    }

    public void deleteAll() {
        manipulationUnitJpaRepository.deleteAll();
    }
}
