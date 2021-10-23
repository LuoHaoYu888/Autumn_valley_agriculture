package com.example.autumn_valley_agriculture;

import com.example.autumn_valley_agriculture.core.CacheKey;
import com.example.autumn_valley_agriculture.core.RemoveKey;
import com.example.autumn_valley_agriculture.mapper.StudentMapper;
import com.example.autumn_valley_agriculture.service.StudentService;
import com.example.autumn_valley_agriculture.util.RedisUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AutumnValleyAgricultureApplicationTests {

    @Autowired
    private StudentService studentService;

    @Autowired
    private RedisUtil redisUtil;

    @Test
    void contextLoads() {
        try {
            System.out.println(studentService.getAll());
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test2(){
        studentService.del();
    }

}
