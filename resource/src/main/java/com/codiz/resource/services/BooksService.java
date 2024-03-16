package com.codiz.resource.services;

import com.codiz.resource.dto.BooksDetails;
import com.codiz.resource.models.BooksModel;
import com.codiz.resource.repository.BooksRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class BooksService {
    private final BooksRepository repository;

    public List<String> registerBook(List<BooksDetails> details) {
        log.info("registering book details");

        try {
            List<BooksModel> booksModels = getBooksModels(details);
            log.info("starting the book insertions");
            // Save the book details using repository
             repository.saveAll(booksModels);
             log.info("insertions complete");
           /* return repository.saveAll(Collections.singletonList(booksModel));*/
        } catch (Exception e) {
            log.error("Error registering book details", e);
            throw new RuntimeException("Failed to register book details", e);
        }
        return new ArrayList<>();
    }

    private static List<BooksModel> getBooksModels(List<BooksDetails> details) {
        List<BooksModel> booksModels = new ArrayList<>();
        for(BooksDetails booksDetails: details)
        {
           BooksModel booksModel = new BooksModel();

           booksModel.setBookNo(booksDetails.getBookNo());
           booksModel.setBookName(booksDetails.getBookName());
           booksModel.setSubject(booksDetails.getSubject());
           booksModel.setBookClass(booksDetails.getBookClass());

           booksModels.add(booksModel);


        }
        return booksModels;
    }

}
