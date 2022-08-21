package com.example.demo1.Student;


import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("management/api/v1/students")
public class StudentManagementControl {

    private static final List<Student> STUDENTS = Arrays.asList(
            new Student(1,"Ahmed"),
            new Student(2,"Mohamed"),
            new Student(3,"Ali"));

    @GetMapping
    @PreAuthorize("hasAnyRole('Role_ADMIN','ROLE_ADMINTRAINEE')")
    public  List<Student> getAllStudents() {
        System.out.println("getAllStudents");
        return STUDENTS;
    }

    @PostMapping
    @PreAuthorize("hasAuthority('student:write')")
    public void registerNewStudent(@RequestBody Student student){

        System.out.println("registerNewStudent");
        System.out.println(student);
    }

    @DeleteMapping(path = "{studentId}")
    @PreAuthorize("hasAuthority('student:write')")
    public void deleteStudent(@PathVariable("studentId") Integer studentId){
        System.out.println("deleteStudent");
        System.out.println(studentId);
    }

    @PutMapping(path = "{studentId}")
    @PreAuthorize("hasAuthority('student:write')")
    public void updateStudent(@PathVariable("studentId")Integer studentId,@RequestBody Student student){
        System.out.println(String.format("updateStudent"));
        System.out.println(String.format("%s %s" ,studentId,student));
    }

}
