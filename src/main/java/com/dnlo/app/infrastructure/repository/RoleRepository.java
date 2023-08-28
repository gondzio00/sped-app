package com.dnlo.app.infrastructure.repository;

import com.dnlo.app.infrastructure.ERole;
import com.dnlo.app.infrastructure.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}