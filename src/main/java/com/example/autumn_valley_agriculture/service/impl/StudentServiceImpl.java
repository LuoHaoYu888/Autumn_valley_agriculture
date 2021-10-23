package com.example.autumn_valley_agriculture.service.impl;

import com.example.autumn_valley_agriculture.core.CacheKey;
import com.example.autumn_valley_agriculture.core.RedisCache;
import com.example.autumn_valley_agriculture.core.RemoveKey;
import com.example.autumn_valley_agriculture.mapper.StudentMapper;
import com.example.autumn_valley_agriculture.pojo.Student;
import com.example.autumn_valley_agriculture.service.StudentService;
import com.example.autumn_valley_agriculture.util.RedisUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Override
    @RedisCache(CacheKey.STUDENT_ALL)//自定义注释
    public List<Student> getAll() throws JsonProcessingException {
        return studentMapper.getAll();
    }

    @RemoveKey(CacheKey.STUDENT_ALL)
    public void del(){

    }
}
