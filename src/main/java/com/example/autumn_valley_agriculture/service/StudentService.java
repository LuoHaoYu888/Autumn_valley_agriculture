package com.example.autumn_valley_agriculture.service;

import com.example.autumn_valley_agriculture.pojo.Student;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;

public interface StudentService {
    List<Student> getAll() throws JsonProcessingException;
    void del();
}
