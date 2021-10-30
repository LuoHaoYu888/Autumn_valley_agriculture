package com.example.autumn_valley_agriculture.service;

import com.example.autumn_valley_agriculture.pojo.Userinfo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface BusinesssysService {
    Userinfo validate(String user, String pwd) throws JsonProcessingException;
    void del();
    Userinfo selUser(String user);

    List<Userinfo> selNameVal(String val);
    PageInfo<Userinfo> getCurrentPageUserInfo(Integer currentPage, Integer pageSize,String val);

    int addUserInfo(Userinfo userinfo);
}
