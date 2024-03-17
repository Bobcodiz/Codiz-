package com.codiz.resource.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class BookIssued {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String bookNo;
    private String reNo;
}
