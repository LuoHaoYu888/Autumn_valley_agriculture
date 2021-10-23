package com.example.autumn_valley_agriculture.controller;

import com.example.autumn_valley_agriculture.pojo.Userinfo;
import com.example.autumn_valley_agriculture.service.BusinesssysService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BusinesssysController {

    @Autowired
    private BusinesssysService businesssysService;

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

    @GetMapping("/getPuser")
    public PageInfo<Userinfo> getPuser(){
        PageInfo<Userinfo> p=null;
        PageHelper.startPage(0,4);
        p=new PageInfo<>(businesssysService.getPuser());
        return p;
    }
}
