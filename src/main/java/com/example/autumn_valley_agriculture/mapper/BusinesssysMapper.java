package com.example.autumn_valley_agriculture.mapper;

import com.example.autumn_valley_agriculture.pojo.Userinfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BusinesssysMapper {
    Userinfo validate(@Param("user") String user,@Param("pwd") String pwd);
    Userinfo selUser(@Param("user")String user);
    List<Userinfo> getPuser();
    List<Userinfo> selNameVal(@Param("val") String val);
    int addUserInfo(@Param("userinfo")Userinfo userinfo);
}
