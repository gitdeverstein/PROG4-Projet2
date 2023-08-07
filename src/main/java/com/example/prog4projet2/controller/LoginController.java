package com.example.prog4projet2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
    @RequestMapping("/login")
    public String showLoginPage(){

        return "redirect:/login";
    }

    @PostMapping("/login")
    public String redirect(){
        return "redirect:/employees";
    }

    @GetMapping("/employees.html")
    public String employeesPage() {
        return "employees";
    }
}
