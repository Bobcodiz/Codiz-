package com.codiz.resource.repository;

import com.codiz.resource.models.BooksModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BooksRepository extends ListCrudRepository<BooksModel,String> {
}
