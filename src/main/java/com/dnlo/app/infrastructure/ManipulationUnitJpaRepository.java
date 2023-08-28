package com.dnlo.app.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ManipulationUnitJpaRepository extends JpaRepository<ManipulationUnitEntity, String> {
}
