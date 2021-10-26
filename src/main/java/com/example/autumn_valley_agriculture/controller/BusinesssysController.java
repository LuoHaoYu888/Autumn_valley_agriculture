package com.example.autumn_valley_agriculture.controller;

import com.example.autumn_valley_agriculture.pojo.Userinfo;
import com.example.autumn_valley_agriculture.service.BusinesssysService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Collections;
import java.util.List;

@RestController
public class BusinesssysController {

    @Autowired
    private BusinesssysService businesssysService;
    private int pageSize=4;

    @GetMapping("/validate")
    public int validate(String user, String pwd) throws JsonProcessingException {
        int i=0;
        Userinfo validate = businesssysService.validate(user, pwd);
        if (validate!=null){
            if (validate.getIsAdmin()==1&&validate.getUseStatus()==1){
                i=1;
            }
        }
        return i;
    }
    @GetMapping("/selUser")
    public Userinfo selUser(String user) throws JsonProcessingException {
        return businesssysService.selUser(user);
    }

    @GetMapping("/selVal")
    public PageInfo<Userinfo> selVal(String val,HttpServletRequest request){
        PageHelper.startPage(1,pageSize);
        PageInfo<Userinfo> p = new PageInfo<>(businesssysService.selNameVal(val));
        request.getServletContext().setAttribute("pageNum",p.getPageNum());
        request.getServletContext().setAttribute("pages",p.getPages());
        return p;
    }

    @GetMapping("/refreshto")
    public PageInfo<Userinfo> refreshTo(Integer currentPage, Integer pageSize,String val){
        System.out.println(val);
        PageInfo<Userinfo> p = businesssysService.getCurrentPageUserInfo(currentPage, pageSize,val);
        System.out.println(p);
        return p;
    }
}
