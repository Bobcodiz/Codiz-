package com.codiz.resource.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class StudentModel {
    @Id
    private String regNo;
    private String firstName;
    private String LastName;
    private String grade;
}
