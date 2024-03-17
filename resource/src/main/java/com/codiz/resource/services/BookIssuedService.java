package com.codiz.resource.services;

import com.codiz.resource.dto.BookIssuedDetails;
import com.codiz.resource.models.BookIssued;
import com.codiz.resource.repository.BookIssuedRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
            List<BookIssued> bookIssueds = getIssuedBooks(details);
            return issuedRepository.saveAll(bookIssueds);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
    private static List<BookIssued> getIssuedBooks(List<BookIssuedDetails> details)
    {
        try {
            List<BookIssued> issueds = new ArrayList<>();
            for (BookIssuedDetails issuedDetails:details)
            {
                BookIssued issued = new BookIssued();
                issued.setBooksModel(issuedDetails.getBooksModel());
                issued.setStudentModel(issuedDetails.getStudentModel());
                issueds.add(issued);
            }
            return issueds;
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
