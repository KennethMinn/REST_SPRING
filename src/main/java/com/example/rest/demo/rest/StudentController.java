package com.example.rest.demo.rest;

import com.example.rest.demo.entity.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {
    List<Student> students = new ArrayList<>();
    @GetMapping("/students")
    public List<Student> getAllStudents(){
        students.add(new Student("Kenneth"));
        return students;
    }
    @GetMapping("/students/{studentId}") //must match
    public Student getStudent(@PathVariable int studentId){
        if( studentId >= students.size() || studentId < 0){
            throw new StudentNotFoundException("Student id not found : " + studentId);
        }
        return students.get(studentId);
    }
}
