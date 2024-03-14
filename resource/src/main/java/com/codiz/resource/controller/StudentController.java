package com.codiz.resource.controller;

import com.codiz.resource.dto.StudentDetails;
import com.codiz.resource.models.StudentModel;
import com.codiz.resource.services.StudentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/students")
public class StudentController {
    private final StudentService studentService;

    @PostMapping("/register")
    public ResponseEntity<StudentModel> register(@RequestBody StudentDetails details)
    {
        log.info("request to register a student was made");
        return ResponseEntity.status(HttpStatus.CREATED).body(studentService.register(details));
    }

    @PutMapping("/update/{regNo}")
    public ResponseEntity<StudentModel> update(@PathVariable String regNo,
                                               @RequestBody StudentDetails details)
    {
        log.info("request to update student details");
        return ResponseEntity.status(HttpStatus.OK).body(studentService.update(regNo,details));
    }

    @GetMapping("/find-all")
    public ResponseEntity<List<StudentModel>> getAllStudents()
    {
        log.info("request to get all students");
        return ResponseEntity.status(HttpStatus.FOUND).body(studentService.getAllStudents());
    }
    @GetMapping("/find/{regNo}")
    public ResponseEntity<StudentModel> getStudent(@PathVariable String regNo)
    {
        log.info("request to get one student by reg no");
        return ResponseEntity.status(HttpStatus.FOUND).body(studentService.getStudent(regNo));
    }
    @GetMapping("/find-by-grades/{grade}")
    public ResponseEntity<List<StudentModel>> findAllByGrade(@PathVariable String grade)
    {
        log.info("request to get students by grade");
        return ResponseEntity.status(HttpStatus.FOUND).body(studentService.getAllStudentByGrade(grade));
    }
}
