package com.codiz.resource.controller;

import com.codiz.resource.dto.BookIssuedDetails;
import com.codiz.resource.models.BookIssued;
import com.codiz.resource.services.BookIssuedService;
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
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/issue-book")
public class IssuedController {
    private final BookIssuedService issuedService;

    @PostMapping("/issue")
    public ResponseEntity<List<BookIssued>> issueBooks(@RequestBody List<BookIssuedDetails> det)
    {
        log.info("request to issue book");
        return ResponseEntity.status(HttpStatus.OK).body(
                issuedService.issueBook(det)
        );
    }
}
