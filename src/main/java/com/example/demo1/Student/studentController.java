package com.example.demo1.Student;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("api/v1/students")
public class studentController {


    private static final List<Student> STUDENTS = Arrays.asList(
            new Student(1,"Ahmed"),
            new Student(2,"Mohamed"),
            new Student(3,"Ali"));



    @GetMapping(path = "{studentId}")
    public Student getStudent (@PathVariable("studentId") Integer studentId){
         return STUDENTS.stream()
                 .filter(Student -> studentId.equals(Student.getStudentId()))
                 .findFirst()
                 .orElseThrow(()->new IllegalStateException("student"+studentId+"doesn't exist"));
     }
}
