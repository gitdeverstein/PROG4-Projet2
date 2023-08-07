package com.example.prog4projet2.service;

import com.example.prog4projet2.entity.EmployeeEntity;
import com.example.prog4projet2.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl{
    private final EmployeeRepository employeeRepository;

    public List<EmployeeEntity> getAllEmployee() {
        return employeeRepository.findAll();
    }

    public void saveOne(EmployeeEntity employee){
        employeeRepository.save(employee);
    }

    public void delete(int id){
        employeeRepository.deleteById(id);
    }

    public EmployeeEntity findEmployeeById(int id){
        return employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("employee not found"));
    }

    public Optional<EmployeeEntity> getEmployeeById(int id){;
        return employeeRepository.findById(id);
    }
    public Optional<EmployeeEntity> getEmployeeProfileById(int id){
        return employeeRepository.findById(id);
    }

    public List<EmployeeEntity> getEmployeeByFirstName(String firstname){
        return employeeRepository.findByFirstNameContaining(firstname);
    }

    public List<EmployeeEntity> getEmployeeByLastName(String lastname){
        return employeeRepository.findByLastNameContaining(lastname);
    }

    public List<EmployeeEntity> getEmployeeByFunction(String function){
        return employeeRepository.findByFunction(function);
    }

    public List<EmployeeEntity> getEmployeeByGender(String gender){
        return employeeRepository.findByGender(gender);
    }

    public List<EmployeeEntity> getEmployeeByEngagement(String engagementDate) {
        return employeeRepository.findByEngagementDate(engagementDate);
    }

    public List<EmployeeEntity> getEmployeeByResignation(String resignationDate) {
        return employeeRepository.findByResignationDate(resignationDate);
    }
}
