package com.example.prog4projet2.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;


@Entity
@Builder
@Table(name= "phone_number")
@AllArgsConstructor
@NoArgsConstructor
public class PhoneNumberEntity {
    @Id
    private int id;

    private String phoneNumber;
    @ManyToOne
    @JoinColumn(name = "employee_id")
    private EmployeeEntity employee;
}
