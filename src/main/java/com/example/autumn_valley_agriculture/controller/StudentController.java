package com.example.autumn_valley_agriculture.controller;

import com.example.autumn_valley_agriculture.pojo.Student;
import com.example.autumn_valley_agriculture.service.StudentService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("student")
    public List<Student> getAll() throws JsonProcessingException {
        return studentService.getAll();
    }
}
