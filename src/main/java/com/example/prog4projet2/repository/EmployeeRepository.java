package com.example.prog4projet2.repository;

import com.example.prog4projet2.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Integer> {
    List<EmployeeEntity> findAll();
    @Query("SELECT e.lastName FROM EmployeeEntity e where e.lastName ilike ?1")
    List<EmployeeEntity> findByLastNameContaining(String pattern);
    @Query("SELECT e.firstName FROM EmployeeEntity e where e.firstName ilike ?1")
    List<EmployeeEntity> findByFirstNameContaining(String pattern);

    @Query("SELECT e.function FROM EmployeeEntity e where e.function ilike ?1")
    List<EmployeeEntity> findByFunction(String pattern);
    @Query("SELECT e.gender FROM EmployeeEntity e where e.gender ilike ?1")
    List<EmployeeEntity> findByGender(String gender);

    @Query("SELECT e.engagementDate FROM EmployeeEntity e ORDER BY e.engagementDate DESC")
    List<String> findByEngagementDate(); // lay list string ngmaba no blem eto

    @Query("SELECT e.resignationDate FROM EmployeeEntity e ORDER BY e.resignationDate DESC")
    List<String> findByResignationDate();
}
