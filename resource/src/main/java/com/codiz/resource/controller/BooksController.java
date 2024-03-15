package com.codiz.resource.controller;

import com.codiz.resource.dto.BooksDetails;
import com.codiz.resource.models.BooksModel;
import com.codiz.resource.services.BooksService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/api/books")
@RequiredArgsConstructor
public class BooksController {

    private final BooksService booksService;

    @PostMapping("/register")
    public ResponseEntity<List<String>> registerBooks(@RequestBody List<BooksDetails> detailsList) {
        log.info("request to register new books");
        List<String> registeredBooks = booksService.registerBook(detailsList);
        return ResponseEntity.status(HttpStatus.CREATED).body(registeredBooks);
    }

}
