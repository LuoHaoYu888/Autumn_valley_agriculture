package com.example.autumn_valley_agriculture.mapper;

import com.example.autumn_valley_agriculture.pojo.Student;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentMapper {
    List<Student> getAll();
}
