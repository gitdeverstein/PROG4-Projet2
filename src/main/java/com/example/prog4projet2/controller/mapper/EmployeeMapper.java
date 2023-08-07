package com.example.prog4projet2.controller.mapper;

import com.example.prog4projet2.entity.EmployeeConfEntity;
import com.example.prog4projet2.entity.EmployeeEntity;
import com.example.prog4projet2.model.CreateEmployee;
import com.example.prog4projet2.model.Employee;
import com.example.prog4projet2.model.EmployeeConf;
import lombok.Getter;
import lombok.Setter;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@Getter
@Setter
public class EmployeeMapper {

    public EmployeeEntity toDomain(CreateEmployee createEmployee) throws IOException {

        EmployeeEntity domainEmployee= EmployeeEntity.builder()
                .id(Integer.parseInt(createEmployee.getId()))
                .firstName(createEmployee.getFirstName())
                .lastName(createEmployee.getLastName())
                .birthDate(createEmployee.getBirthDate())
                .profile(createEmployee.getProfile().getBytes())
                .gender(createEmployee.getGender())
                .registrationNumber(createEmployee.getRegistrationNumber())
                .personalEmail(createEmployee.getPersonalEmail())
                .address(createEmployee.getAddress())
                .childrenCount(createEmployee.getChildrenCount())
                .engagementDate(createEmployee.getEngagementDate())
                .resignationDate(createEmployee.getResignationDate())
                .cnapsNumber(createEmployee.getCnapsNumber())
                .build();
        return domainEmployee;
    }

    public EmployeeConfEntity toDomain(EmployeeConf employeeConf)throws IOException{

        EmployeeConfEntity domainEmployeeConf= EmployeeConfEntity.builder()
                .idConf(employeeConf.getIdConf())
                .companyName(employeeConf.getCompanyName())
                .companyDescription(employeeConf.getCompanyDescription())
                .logo(employeeConf.getLogo().getBytes())
                .companySlogan(employeeConf.getCompanySlogan())
                .companyAddress(employeeConf.getCompanyAddress())
                .companyPhone(employeeConf.getCompanyPhone())
                .companyFiscalIdentity(employeeConf.getCompanyFiscalIdentity())
                .build();
        return domainEmployeeConf;
    }

    public Employee toView(EmployeeEntity employeeEntity){
        Employee viewCreateEmployee = Employee.builder()
                .id(employeeEntity.getId())
                .firstName(employeeEntity.getFirstName())
                .lastName(employeeEntity.getLastName())
                .profile("data:image/png;base64," + Base64.encodeBase64String(employeeEntity.getProfile()))
                .gender(employeeEntity.getGender())
                .birthDate(employeeEntity.getBirthDate())
                .registrationNumber(employeeEntity.getRegistrationNumber())
                .build();
        return viewCreateEmployee;
    }
}
