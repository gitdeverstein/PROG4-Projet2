package com.example.prog4projet2.repository;

import com.example.prog4projet2.entity.EmployeeConfEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeConfRepository extends JpaRepository<EmployeeConfEntity, Long> {
    Optional<EmployeeConfEntity> findByEmployeeId(int employeeId);
}
