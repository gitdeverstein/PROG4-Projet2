package com.example.prog4projet2.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name= "employee")
@Data
@Getter
@Setter
public class EmployeeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne(mappedBy = "employee", cascade = CascadeType.ALL)
    private CINEntity cinEntity;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PhoneNumberEntity> phoneNumbers = new ArrayList<>();

    private String registrationNumber;
    @PostPersist
    private void generateRegistrationNumber(){
        String yearLastToDigits= String.valueOf(LocalDate.now().getYear()).substring(4);
        this.registrationNumber= "OFFICER-"+ yearLastToDigits+String.format("%04d", id);
    }

    private String firstName;

    private String lastName;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate birthDate;

    private String gender;

    private String personalEmail;

    private String CIN;

    private String address;

    private int childrenCount;

    private Date engagementDate;

    private Date resignationDate;

    private byte[] profile;

    @Enumerated(EnumType.STRING)
    private socioProfessionalCategory socioProfessionalCategory;

    private enum socioProfessionalCategory{
        M1, M2, OS1, OS2, OS3, OP1A, OP1B, OP2, OP3
    }

    private int cnapsNumber;
}
