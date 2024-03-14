package com.codiz.resource.services;

import com.codiz.resource.dto.BooksDetails;
import com.codiz.resource.models.BooksModel;
import com.codiz.resource.repository.BooksRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class BooksService {
    private final BooksRepository repository;

    public List<BooksModel> registerBook(BooksDetails details)
    {
        log.info("registering book details");
        try {
            BooksModel books = new BooksModel();
            books.setBookNo(details.getBookNo());
            books.setBookName(details.getBookName());
            books.setSubject(details.getSubject());
            books.setBookClass(details.getBookClass());

            return repository.saveAll(books);
        }catch (Exception e)
        {
            throw new RuntimeException("");
        }
    }
}
