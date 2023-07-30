package com.example.prog4projet2.model;

import jakarta.persistence.Id;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Employee implements Serializable {
    @Id
    private int id;
    private String registrationNumber;
    private String firstName;
    private String lastName;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate birthDate;

    private String gender;

    private String personalEmail;

    private String function;

    private String profile;

    private String CIN;

    private String address;

    private String engagementDate;

    private String resignationDate;

    private int childrenCount;

    private String cnapsNumber;
}
