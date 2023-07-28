package com.example.prog4projet2.model;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class EmployeeConf implements Serializable {
    private int id;

    private String companyName;

    private String companyDescription;

    private String companySlogan;

    private String companyAddress;

    private String companyPhone;

    private String companyFiscalIdentity;

    private MultipartFile logo;
}
