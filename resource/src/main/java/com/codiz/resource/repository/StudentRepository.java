package com.codiz.resource.repository;

import com.codiz.resource.models.StudentModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<StudentModel,String> {
    StudentModel findStudentByRegNo(String regNo);


    List<StudentModel> findStudentsByGrade(String grade);
}
