package com.codiz.resource.services;

import com.codiz.resource.dto.BookIssuedDetails;
import com.codiz.resource.models.BookIssued;
import com.codiz.resource.repository.BookIssuedRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class BookIssuedService {

    private final BookIssuedRepository issuedRepository;

    public List<BookIssued> issueBook(List<BookIssuedDetails> details)
    {
        log.info("saving issued book");
        try {
            return null;
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
