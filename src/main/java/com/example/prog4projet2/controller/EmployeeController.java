package com.example.prog4projet2.controller;

import com.example.prog4projet2.controller.mapper.EmployeeMapper;
import com.example.prog4projet2.entity.EmployeeConfEntity;
import com.example.prog4projet2.entity.EmployeeEntity;
import com.example.prog4projet2.model.CreateEmployee;
import com.example.prog4projet2.model.EmployeeConf;
import com.example.prog4projet2.repository.EmployeeConfRepository;
import com.example.prog4projet2.repository.EmployeeRepository;
import com.example.prog4projet2.service.EmployeeConfServiceImpl;
import com.example.prog4projet2.service.EmployeeServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
@AllArgsConstructor
public class EmployeeController {
    private final EmployeeServiceImpl employeeServiceImpl;
    private final EmployeeConfServiceImpl employeeConfService;
    private final EmployeeRepository employeeRepository;
    private EmployeeMapper mapper;
    private final EmployeeConfRepository employeeConfRepository;

    @GetMapping("/employees")
    public String getAllEmployees(Model model) {
        model.addAttribute("employees", employeeServiceImpl.getAllEmployee());
        model.addAttribute("employeeConf", employeeConfService.getAllEmployeeConf());
        return "employees";
    }

    @GetMapping ("/addEmployee")
    public String addNewEmployee(Model model){
        CreateEmployee createEmployee = new CreateEmployee();
        EmployeeConf employeeConf= new EmployeeConf();
        model.addAttribute("employee", createEmployee);
        model.addAttribute("employeeConf", employeeConf);
        return "addEmployee";
    }

    @PostMapping ("/saveEmployee")
    public String saveEmployee(@ModelAttribute("employee") CreateEmployee restCreateEmployee,
                                @ModelAttribute("employeeConf") EmployeeConf restEmployeeConf) throws IOException{
        EmployeeEntity employee= mapper.toDomain(restCreateEmployee);
        EmployeeConfEntity employeeConf= mapper.toDomain(restEmployeeConf);
        employeeConfService.saveOne(employeeConf);
        employeeServiceImpl.saveOne(employee);
        return "redirect:/employees";
    }

    @GetMapping ("/employees/{id}")
    public String viewEmployee(@PathVariable int id, Model model){
        model.addAttribute("employee", employeeServiceImpl.findEmployeeById(id));
        return "employeeFile";
    }

    @PutMapping("/employees/{id}")
    public String updateEmployee(@PathVariable Integer id,
                                 @ModelAttribute EmployeeEntity updatedEmployee,
                                 @ModelAttribute EmployeeConfEntity updatedEmployeeConf){
        EmployeeEntity employee= employeeRepository.save(updatedEmployee);
        EmployeeConfEntity employeeConf= employeeConfRepository.save(updatedEmployeeConf);
        employee.setFirstName(updatedEmployee.getFirstName());
        employee.setLastName(updatedEmployee.getLastName());
        employee.setGender(updatedEmployee.getGender());
        employee.setPersonalEmail(updatedEmployee.getPersonalEmail());
        employee.setRegistrationNumber(updatedEmployee.getRegistrationNumber());
        employee.setAddress(updatedEmployee.getAddress());
        employee.setProfile(updatedEmployee.getProfile());
        employee.setCIN(updatedEmployee.getCIN());
        employee.setChildrenCount(updatedEmployee.getChildrenCount());
        employee.setCnapsNumber(updatedEmployee.getCnapsNumber());
        employee.setEngagementDate(updatedEmployee.getEngagementDate());
        employee.setResignationDate(updatedEmployee.getResignationDate());
        employeeConf.setCompanyName(updatedEmployeeConf.getCompanyName());
        employeeConf.setCompanyDescription(updatedEmployeeConf.getCompanyDescription());
        employeeConf.setCompanySlogan(updatedEmployeeConf.getCompanySlogan());
        employeeConf.setCompanyAddress(updatedEmployeeConf.getCompanyAddress());
        employeeConf.setCompanyFiscalIdentity(updatedEmployeeConf.getCompanyFiscalIdentity());
        employeeConf.setCompanyPhone(updatedEmployeeConf.getCompanyPhone());
        employeeRepository.save(employee);
        employeeConfRepository.save(employeeConf);
        return "redirect:/employees";
    }

    @PostMapping("/saveProfile/{id_employee}")
    public String saveProfile(
            @RequestParam("profile") MultipartFile profile,
            @PathVariable("id_employee") Integer id_employee,
            @PathVariable("id_employee_conf") Integer id_employee_conf,
            @PathVariable("logo") MultipartFile logo) {
        EmployeeEntity employee = employeeServiceImpl.getEmployeeById(id_employee).get();
        EmployeeConfEntity employeeConf= employeeConfService.getEmployeeConfById(id_employee_conf).get();
        employeeConfService.saveOne(employeeConf);
        employeeServiceImpl.saveOne(employee);

        return "redirect:/employees";
    }
}
