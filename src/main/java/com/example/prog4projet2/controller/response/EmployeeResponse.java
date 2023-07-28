package com.example.prog4projet2.controller.response;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;

@Getter
@Setter
@Builder
public class EmployeeResponse {
    private int id;
    private String firstName;
    private String lastName;
    private String gender;
    private LocalDate birthDate;
    private String CIN;
    private String personalEmail;
    private MultipartFile profile;
    private String registrationNumber;
    private String companyName;
    private String companyDescription;
}
