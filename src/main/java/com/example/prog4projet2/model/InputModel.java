package com.example.prog4projet2.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InputModel {
    private String firstName;
    private String lastName;
    private String function;
    private String gender;
    private String engagementDate;
    private String resignationDate;
}
