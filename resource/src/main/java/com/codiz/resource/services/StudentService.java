package com.codiz.resource.services;

import com.codiz.resource.dto.StudentDetails;
import com.codiz.resource.models.StudentModel;
import com.codiz.resource.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentModel register(StudentDetails details)
    {
        log.info("service to insert student details");
        StudentModel model = new StudentModel();
        try {
            model.setRegNo(details.getRegNo());
            model.setFirstName(details.getFirstName());
            model.setLastName(details.getLastName());
            model.setGrade(details.getGrade());
        }catch (Exception e){
            throw new RuntimeException("could not insert student");
        }
        return studentRepository.save(model);
    }
    public StudentModel update(String regNo,StudentDetails details)
    {
        log.info("service to update the students details");
        StudentModel student = new StudentModel();
        try {
           student = studentRepository.findStudentByRegNo(regNo);
           student.setRegNo(details.getRegNo());
           student.setFirstName(details.getFirstName());
           student.setLastName(details.getLastName());
           student.setGrade(details.getGrade());
        }catch (Exception e)
        {

            throw new RuntimeException("could not update student");
        }
        return studentRepository.save(student);
    }

    public List<StudentModel> getAllStudents()
    {
        log.info("service to get all students");
        try {
            return studentRepository.findAll();
        }catch (Exception e){
            throw new RuntimeException("could not get the students");
        }
    }

    public StudentModel getStudent(String regNo)
    {
        log.info("service to get a student");
        try {
            StudentModel student = studentRepository.findStudentByRegNo(regNo);
            return student;
        }catch (Exception e){
            throw new RuntimeException("error occurred");
        }
    }

    public List<StudentModel> getAllStudentByGrade(String grade)
    {
        log.info("getting all students by grade");
        try {
            return studentRepository.findStudentsByGrade(grade);
        }catch (Exception e)
        {
            throw new RuntimeException("could not find students");
        }
    }
}
