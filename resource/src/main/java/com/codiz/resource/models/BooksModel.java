package com.codiz.resource.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class BooksModel {
    @Id
    private String bookNo;
    private String bookName;
    private String subject;
    private String bookClass;
}
