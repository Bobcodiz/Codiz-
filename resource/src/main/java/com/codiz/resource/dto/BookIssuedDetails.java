package com.codiz.resource.dto;

import com.codiz.resource.models.BooksModel;
import com.codiz.resource.models.StudentModel;
import lombok.Data;

@Data
public class BookIssuedDetails {
    private BooksModel booksModel;
    private StudentModel studentModel;
}
