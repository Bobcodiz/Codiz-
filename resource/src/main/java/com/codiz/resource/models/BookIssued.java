package com.codiz.resource.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class BookIssued {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    @JoinColumn(referencedColumnName = "bookNo")
    private BooksModel booksModel;

    @ManyToOne
    @JoinColumn(referencedColumnName = "regNo")
    private StudentModel studentModel;

}
