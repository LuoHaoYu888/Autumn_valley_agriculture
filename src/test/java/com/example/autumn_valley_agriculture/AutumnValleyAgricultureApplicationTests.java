package com.example.autumn_valley_agriculture;

import com.example.autumn_valley_agriculture.controller.BusinesssysController;
import com.example.autumn_valley_agriculture.service.BusinesssysService;
import com.example.autumn_valley_agriculture.util.RedisUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@SpringBootTest
class AutumnValleyAgricultureApplicationTests {

    @Autowired
    private BusinesssysService businesssysService;

    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private BusinesssysController businesssysController;

    @Test
    void contextLoads() {
        try {
            System.out.println(businesssysController.validate("17766666666","123456"));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test3(){
        System.out.println(businesssysService.selUser("wangwu18888"));
    }
    @Test
    public void test4(){
        //System.out.println(businesssysController.selVal("张"));
    }

    @Test
    public void test2(){
        businesssysService.del();
    }

}
