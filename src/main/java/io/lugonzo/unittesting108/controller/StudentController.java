package io.lugonzo.unittesting108.controller;

import io.lugonzo.unittesting108.model.Student;
import lombok.var;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    @GetMapping("/stud")
    public Student getStudent(){

        var student1 =  Student.builder()
                .id("AEZAKMI")
                .name("June")
                .admissionNo(98831L)
                .age(21)
                .build();

        return  student1;
    }
}
