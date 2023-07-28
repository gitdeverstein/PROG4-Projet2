package com.example.prog4projet2.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name= "employeeConf")
@Data
@Getter
@Setter
public class EmployeeConfEntity {
    @Id
    private int id;

    private String companyName;

    private String companyDescription;

    private String companySlogan;

    private String companyAddress;

    private String companyPhone;

    private String companyFiscalIdentity;

    @Lob
    private String logo;

    @OneToOne
    @JoinColumn(name = "employee_id")
    private EmployeeEntity employee;
}
