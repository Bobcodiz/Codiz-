package com.codiz.resource.services;

import com.codiz.resource.dto.StudentDetails;
import com.codiz.resource.models.StudentModel;
import com.codiz.resource.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

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
}
