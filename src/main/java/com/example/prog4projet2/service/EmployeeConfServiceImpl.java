package com.example.prog4projet2.service;

import com.example.prog4projet2.entity.EmployeeConfEntity;
import com.example.prog4projet2.repository.EmployeeConfRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class EmployeeConfServiceImpl {
    private final EmployeeConfRepository employeeConfRepository;


    public Optional<EmployeeConfEntity> getEmployeeConfById(Long id) {
        return employeeConfRepository.findById(id);
    }


    public EmployeeConfEntity findEmployeeConfById(int id) {
        return employeeConfRepository.findByEmployeeId(id).orElseThrow(() -> new RuntimeException("Couldn't find employeeConf"));
    }

    public void saveOne(EmployeeConfEntity employeeConf) {
        employeeConfRepository.save(employeeConf);
    }
}
