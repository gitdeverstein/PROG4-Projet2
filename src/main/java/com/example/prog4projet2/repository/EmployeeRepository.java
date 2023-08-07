package com.example.prog4projet2.repository;

import com.example.prog4projet2.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Integer> {

    @Query("SELECT e FROM EmployeeEntity e where e.lastName ilike ?1")
    List<EmployeeEntity> findByLastNameContaining(String pattern);
    @Query("SELECT e FROM EmployeeEntity e where e.firstName ilike ?1")
    List<EmployeeEntity> findByFirstNameContaining(String pattern);

    @Query("SELECT e FROM EmployeeEntity e where e.function ilike ?1")
    List<EmployeeEntity> findByFunction(String pattern);
    @Query("SELECT e FROM EmployeeEntity e where e.gender ilike ?1")
    List<EmployeeEntity> findByGender(String gender);

    @Query("SELECT e FROM EmployeeEntity e where e.engagementDate ilike ?1")
    List<EmployeeEntity> findByEngagementDate(String engagementDate);

    @Query("SELECT e FROM EmployeeEntity e where e.resignationDate ilike ?1")
    List<EmployeeEntity> findByResignationDate(String resignationDate);
}
