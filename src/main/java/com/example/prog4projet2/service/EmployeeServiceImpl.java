package com.example.prog4projet2.service;

import com.example.prog4projet2.entity.EmployeeConfEntity;
import com.example.prog4projet2.entity.EmployeeEntity;
import com.example.prog4projet2.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl{
    private final EmployeeRepository employeeRepository;

    public List<EmployeeEntity> getAllEmployee() {
        return employeeRepository.findAll();
    }

    public void saveAllEmployee(List<EmployeeEntity> employees){
        employeeRepository.saveAll(employees);
    }

    public void saveOne(EmployeeEntity employee){
        employeeRepository.save(employee);
    }

    public EmployeeEntity findEmployeeById(int id){
        return employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("employee not found"));
    }

    public EmployeeConfEntity getLogo(String logo)throws IOException{
        ClassPathResource logoFile= new ClassPathResource("static/images/"+logo+".jpg");
        byte[] logoBytes= StreamUtils.copyToByteArray(logoFile.getInputStream());
        String base64Image= Base64.getEncoder().encodeToString(logoBytes);

        EmployeeConfEntity employeeConfLogo= new EmployeeConfEntity();
        employeeConfLogo.setLogo(base64Image);

        return employeeConfLogo;
    }

    public Optional<EmployeeEntity> getEmployeeById(int id){;
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

    public List<String> getEmployeeByEngagement() {
        return employeeRepository.findByEngagementDate();
    }

    public List<String> getEmployeeByResignation() {
        return employeeRepository.findByResignationDate();
    }
}
