package com.example.autumn_valley_agriculture.controller;

import com.example.autumn_valley_agriculture.pojo.Userinfo;
import com.example.autumn_valley_agriculture.service.BusinesssysService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

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
    public PageInfo<Userinfo> getPuser(HttpServletRequest request){
        PageHelper.startPage(1,4);
        List<Userinfo> puser = businesssysService.getPuser();
        PageInfo<Userinfo> p=new PageInfo<>(puser);
        request.getServletContext().setAttribute("pageNum",p.getPageNum());
        request.getServletContext().setAttribute("pageSize",p.getPageSize());
        request.getServletContext().setAttribute("pages",p.getPages());
        return p;
    }

    @GetMapping("/toPage")
    public PageInfo<Userinfo> toPage(String val,HttpServletRequest request){
        PageHelper.startPage(Integer.parseInt(val),4);
        List<Userinfo> puser = businesssysService.getPuser();
        PageInfo<Userinfo> p=new PageInfo<>(puser);
        request.getServletContext().setAttribute("pageNum",p.getPageNum());
        request.getServletContext().setAttribute("pageSize",p.getPageSize());
        request.getServletContext().setAttribute("pages",p.getPages());
        return p;
    }

    @GetMapping("/refreshto")
    public PageInfo<Userinfo> refreshTo(String val, HttpServletRequest request){
        Integer pageNum = (Integer) request.getServletContext().getAttribute("pageNum");
        Integer pageSize = (Integer) request.getServletContext().getAttribute("pageSize");
        Integer pages = (Integer) request.getServletContext().getAttribute("pages");
        PageInfo<Userinfo> p= null;
        switch (val){
            case "homeP":
                PageHelper.startPage(1,pageSize);
                break;
            case "prevP":
                pageNum=pageNum>1?pageNum-1:pageNum;
                PageHelper.startPage(pageNum,pageSize);
                break;
            case "nextP":
                pageNum=pageNum<pages?pageNum+1:pageNum;
                PageHelper.startPage(pageNum,pageSize);
                break;
            case "lastP":
                PageHelper.startPage(pages,pageSize);
                break;
        }
        p=new PageInfo<>(businesssysService.getPuser());
        request.getServletContext().setAttribute("pageNum",p.getPageNum());
        request.getServletContext().setAttribute("pageSize",p.getPageSize());
        request.getServletContext().setAttribute("pages",p.getPages());
        return p;
    }
}
