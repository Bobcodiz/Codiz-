package com.codiz.resource.dto;

import lombok.Data;

@Data
public class StaffRegistrationDetails {
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String password;
}
