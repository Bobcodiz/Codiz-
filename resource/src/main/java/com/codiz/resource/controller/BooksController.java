package com.codiz.resource.controller;

import com.codiz.resource.dto.BooksDetails;
import com.codiz.resource.models.BooksModel;
import com.codiz.resource.services.BooksService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@Slf4j
@RequestMapping("/api/books")
@RequiredArgsConstructor
public class BooksController {

    private final BooksService booksService;

    @PostMapping("/register")
    public ResponseEntity<List<BooksModel>> registerBooks(@RequestBody List<BooksDetails> detailsList) {
        log.info("request to register new books");
        List<BooksModel> registeredBooks = booksService.registerBook(detailsList);
        return ResponseEntity.status(HttpStatus.CREATED).body(registeredBooks);
    }

    @GetMapping("/all-books")
    public ResponseEntity<List<BooksModel>> getAllBooks()
    {
        log.info("request to get all books");
        return ResponseEntity.status(HttpStatus.FOUND).body(booksService.getAllBooks());
    }

    @GetMapping("/book/{bookNo}")
    public ResponseEntity<BooksModel> getBookByNo(@PathVariable String bookNo)
    {
        log.info("request to get a book");
        return ResponseEntity.status(HttpStatus.FOUND).body(booksService.getBookById(bookNo));
    }

    @GetMapping("/book")
    public ResponseEntity<List<BooksModel>> findAllBooksBySubjectAndClass
            (@RequestParam String subject,@RequestParam int bookClass)
    {
        log.info("request to find All Books By Subject And Class");
        return ResponseEntity.status(HttpStatus.FOUND).body(booksService
                .findAllBooksBySubjectAndClass(subject,bookClass));
    }

    @PutMapping("/updates")
    public ResponseEntity<BooksModel> updateBooks(@RequestParam String bookNo,@RequestBody BooksDetails details)
    {
        log.info("request to update books by book number");
        return ResponseEntity.status(HttpStatus.OK).body(booksService.updateBooks(bookNo,details));
    }
}
