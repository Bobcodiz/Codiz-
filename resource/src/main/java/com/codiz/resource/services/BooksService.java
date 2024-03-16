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

    public List<BooksModel> registerBook(List<BooksDetails> details) {
        log.info("registering book details");

        try {
            List<BooksModel> booksModels = getBooksModels(details);
            log.info("starting the book insertions");
            // Save the book details using repository
            return repository.saveAll(booksModels);
            /* log.info("insertions complete");*/
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

           booksModel.setBookNo(booksDetails.getBookNo());
           booksModel.setBookName(booksDetails.getBookName());
           booksModel.setSubject(booksDetails.getSubject());
           booksModel.setBookClass(booksDetails.getBookClass());

           booksModels.add(booksModel);


        }
        return booksModels;
    }
    public List<BooksModel> getAllBooks(){
        log.info("getting all books");
        try {
            return repository.findAll();
        }catch (Exception e){
            throw new RuntimeException("error",e);
        }
    }
    public BooksModel getBookById(String bookNo)
    {
        log.info("getting book by book number");
        try {
            return repository.findBooksModelByBookNo(bookNo);
        }catch (Exception e)
        {
            throw new RuntimeException(e);
        }
    }

    public List<BooksModel> findAllBooksBySubjectAndClass(String subject,int bookClass)
    {
        log.info("getting all books for the subject");
        try {
            return repository.findBooksModelsBySubjectAndBookClass(subject,bookClass);
        }catch (Exception e)
        {
            throw new RuntimeException(e);
        }
    }

    public BooksModel updateBooks(String bookNo,BooksDetails details)
    {
        log.info("updating the book details");
        try {
            BooksModel book = repository.findById(bookNo).get();
            book.setBookNo(details.getBookNo());
            book.setBookName(details.getBookName());
            book.setSubject(details.getSubject());
            book.setBookClass(details.getBookClass());

            return repository.save(book);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }


}
