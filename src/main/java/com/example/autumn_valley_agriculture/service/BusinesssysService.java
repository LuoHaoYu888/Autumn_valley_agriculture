package com.example.autumn_valley_agriculture.service;

import com.example.autumn_valley_agriculture.pojo.Userinfo;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;

public interface BusinesssysService {
    Userinfo validate(String user, String pwd) throws JsonProcessingException;
    void del();
    Userinfo selUser(String user);
    List<Userinfo> getPuser();
}
