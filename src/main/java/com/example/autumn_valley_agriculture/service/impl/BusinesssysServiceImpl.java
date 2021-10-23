package com.example.autumn_valley_agriculture.service.impl;

import com.example.autumn_valley_agriculture.core.CacheKey;
import com.example.autumn_valley_agriculture.core.RedisCache;
import com.example.autumn_valley_agriculture.core.RemoveKey;
import com.example.autumn_valley_agriculture.mapper.BusinesssysMapper;
import com.example.autumn_valley_agriculture.pojo.Userinfo;
import com.example.autumn_valley_agriculture.service.BusinesssysService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BusinesssysServiceImpl implements BusinesssysService {

    @Autowired
    private BusinesssysMapper businesssysMapper;

    @Override
    public Userinfo validate(String user, String pwd) throws JsonProcessingException {
        return businesssysMapper.validate(user,pwd);
    }

    @RemoveKey(CacheKey.HD_validate)
    public void del(){

    }
}
