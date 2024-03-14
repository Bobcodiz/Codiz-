package com.codiz.resource.services;

import com.codiz.resource.dto.BooksDetails;
import com.codiz.resource.models.BooksModel;
import com.codiz.resource.repository.BooksRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class BooksService {
    private final BooksRepository repository;

    public List<BooksModel> registerBook(BooksDetails details) {
        log.info("registering book details");

        try {
            BooksModel booksModel = new BooksModel(); // Create a new instance of BooksModel

            // Set book details
            booksModel.setBookNo(details.getBookNo());
            booksModel.setBookName(details.getBookName());
            booksModel.setSubject(details.getSubject());
            booksModel.setBookClass(details.getBookClass());

            // Save the book details using repository
            return repository.saveAll(Collections.singletonList(booksModel));
        } catch (Exception e) {
            log.error("Error registering book details", e);
            throw new RuntimeException("Failed to register book details", e); // Throw RuntimeException with appropriate message and cause
        }
    }

}
