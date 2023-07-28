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
public class CreateEmployee implements Serializable {
    @Id
    private int id;
    private String firstName;
    private String lastName;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate birthDate;

    private String gender;

    private String CIN;

    private String personalEmail;

    private String registrationNumber;

    private MultipartFile profile;

    private String address;

    private Date engagementDate;

    private Date resignationDate;

    private int childrenCount;

    private int cnapsNumber;
}
