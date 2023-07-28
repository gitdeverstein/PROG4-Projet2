package com.example.prog4projet2.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@Builder
@Table(name= "cin")
@AllArgsConstructor
@NoArgsConstructor
public class CINEntity {
    @Id
    private String id;

    private String CIN;

    @OneToOne
    @JoinColumn(name = "employee_id")
    private EmployeeEntity employee;
}
