package com.example.prog4projet2.repository;

import com.example.prog4projet2.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Integer> {
    List<EmployeeEntity> findByLastNameContaining(String pattern);
    List<EmployeeEntity> findByFirstNameContaining(String pattern);
    List<EmployeeEntity> findAll();

    List<EmployeeEntity> findAllByGenderContainingIgnoreCase(String gender);

}
