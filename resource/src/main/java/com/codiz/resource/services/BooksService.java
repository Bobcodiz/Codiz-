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

    public List<BooksModel> registerBook(List<BooksDetails> details) {
        log.info("registering book details");

        try {
            List<BooksModel> booksModels = getBooksModels(details);

            // Save the book details using repository
            return repository.saveAll(booksModels);
           /* return repository.saveAll(Collections.singletonList(booksModel));*/
        } catch (Exception e) {
            log.error("Error registering book details", e);
            throw new RuntimeException("Failed to register book details", e);
        }
    }

    private static List<BooksModel> getBooksModels(List<BooksDetails> details) {
        List<BooksModel> booksModels = new ArrayList<>();
        for(BooksDetails booksDetails: details)
        {
           BooksModel booksModel = new BooksModel();

           booksModel.setBookNo(booksModel.getBookNo());
           booksModel.setBookName(booksDetails.getBookName());
           booksModel.setSubject(booksDetails.getSubject());
           booksModel.setBookClass(booksModel.getBookClass());

           booksModels.add(booksModel);

        }
        return booksModels;
    }

}
