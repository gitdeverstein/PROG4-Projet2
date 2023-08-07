package com.example.prog4projet2.controller;

import com.example.prog4projet2.controller.mapper.EmployeeMapper;
import com.example.prog4projet2.entity.EmployeeConfEntity;
import com.example.prog4projet2.entity.EmployeeEntity;
import com.example.prog4projet2.model.CreateEmployee;
import com.example.prog4projet2.model.EmployeeConf;
import com.example.prog4projet2.model.InputModel;
import com.example.prog4projet2.repository.EmployeeConfRepository;
import com.example.prog4projet2.repository.EmployeeRepository;
import com.example.prog4projet2.service.EmployeeConfServiceImpl;
import com.example.prog4projet2.service.EmployeeServiceImpl;
import jakarta.annotation.Nonnull;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@Controller
@AllArgsConstructor
@Slf4j
public class EmployeeController {
    private final EmployeeServiceImpl employeeServiceImpl;
    private final EmployeeConfServiceImpl employeeConfService;
    private final EmployeeRepository employeeRepository;
    private EmployeeMapper mapper;
    private final EmployeeConfRepository employeeConfRepository;
    private final EmployeeConf editableCompany = new EmployeeConf();

    @GetMapping("/employees")
    public String getAllEmployees(Model model,
                                  @ModelAttribute("filter") @Nonnull InputModel input) {
        InputModel filter = new InputModel();
        model.addAttribute("filter", filter);
        log.info("size= {} ", employeeServiceImpl.getAllEmployee().size());

        if (input.getFirstName() == null &&
                input.getLastName() == null &&
                input.getGender() == null &&
                input.getFunction() == null &&
                input.getResignationDate() == null &&
                input.getEngagementDate() == null) {
            model.addAttribute("emp", employeeServiceImpl.getAllEmployee());
        } else {
            log.info("input {}", input);
            model.addAttribute("emp", employeeServiceImpl.getEmployeeByFirstName(input.getFirstName()));
        }
        return "employees";
    }


    @GetMapping("/addEmployee")
    public String addNewEmployee(Model model) {
        CreateEmployee createEmployee = new CreateEmployee();
        model.addAttribute("addEmp", createEmployee);
        return "addEmployee";
    }

    @PostMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute("addEmp") CreateEmployee createEmp)
            throws IOException {
        EmployeeEntity employee = mapper.toDomain(createEmp);
        employeeServiceImpl.saveOne(employee);
        return "redirect:/employees";
    }

    @GetMapping("/employees/{id}")
    public String viewEmployee(@PathVariable int id, Model model) {
        model.addAttribute("employee", employeeServiceImpl.findEmployeeById(id));

        return "employeeFile";
    }

    @PostMapping("/employees/{id}")
    public String updateEmployee(@PathVariable String id,
                                 @ModelAttribute EmployeeEntity updatedEmployee,
                                 @ModelAttribute EmployeeConfEntity updatedEmployeeConf) {
        EmployeeEntity employee = employeeRepository.findById(Integer.valueOf(id))
                .orElseThrow(() -> new IllegalArgumentException("Invalid employee ID: " + id));

        employee.setRegistrationNumber(updatedEmployee.getRegistrationNumber());
        employee.setFirstName(updatedEmployee.getFirstName());
        employee.setLastName(updatedEmployee.getLastName());
        employee.setBirthDate(updatedEmployee.getBirthDate());
        employee.setGender(updatedEmployee.getGender());
        employee.setPersonalEmail(updatedEmployee.getPersonalEmail());
        employee.setProfile(updatedEmployee.getProfile());
        employee.setAddress(updatedEmployee.getAddress());
        employee.setCIN(updatedEmployee.getCIN());
        employee.setCnapsNumber(updatedEmployee.getCnapsNumber());
        employee.setChildrenCount(updatedEmployee.getChildrenCount());
        employee.setEngagementDate(updatedEmployee.getEngagementDate());
        employee.setResignationDate(updatedEmployee.getResignationDate());
        employee.setSocioProfessionalCategory(updatedEmployee.getSocioProfessionalCategory());

        employeeRepository.save(employee);
        return "redirect:/employees";
    }


    @PostMapping("/saveProfile/{id_employee}")
    public String saveProfile(
            @RequestParam("profile") Byte profile,
            @PathVariable("id_employee") Integer id_employee){
        EmployeeEntity employee = employeeServiceImpl.getEmployeeById(id_employee).get();
        EmployeeEntity employeeProfile = employeeServiceImpl.getEmployeeProfileById(profile).get();
        employeeServiceImpl.saveOne(employee);
        employeeServiceImpl.saveOne(employeeProfile);
        return "redirect:/employees";
    }

    @GetMapping("/company")
    public String companyDescription(Model model) {
        model.addAttribute("company", editableCompany);
        return "companyDescription";
    }

    @PostMapping("/update_company")
    public String updateCompany(
            @PathVariable("id_employee_conf") Long id_employee_conf,
            @PathVariable("logo") byte[] logo) {
        EmployeeConfEntity employeeConf = employeeConfService.getEmployeeConfById(id_employee_conf).get();
        EmployeeConfEntity employeeLogo = new EmployeeConfEntity();
        employeeConfService.saveOne(employeeConf);
        employeeConfService.saveOne(employeeLogo);
        employeeLogo.setLogo(logo);
        return "redirect:/employee";
    }

    @DeleteMapping("/delete/{id_employee}")
    public String deleteEmp(@PathVariable int id_employee, HttpSession session) {
        employeeServiceImpl.delete(id_employee);
        session.setAttribute("msg", "Delete successfully");
        return "redirect:/employees";
    }
}
