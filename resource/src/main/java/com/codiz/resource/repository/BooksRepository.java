package com.codiz.resource.repository;

import com.codiz.resource.models.BooksModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BooksRepository extends JpaRepository<BooksModel,String> {
    BooksModel findBooksModelByBookNo(String bookNo);

    List<BooksModel> findBooksModelsBySubjectAndBookClass(String subject,String bookClass);
}
