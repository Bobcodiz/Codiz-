package com.codiz.resource.repository;

import com.codiz.resource.models.BookIssued;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookIssuedRepository extends JpaRepository<BookIssued,Long> {
}
