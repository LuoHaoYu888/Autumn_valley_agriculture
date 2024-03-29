package com.example.autumn_valley_agriculture.service.impl;

import com.example.autumn_valley_agriculture.core.CacheKey;
import com.example.autumn_valley_agriculture.core.RedisCache;
import com.example.autumn_valley_agriculture.core.RemoveKey;
import com.example.autumn_valley_agriculture.mapper.BusinesssysMapper;
import com.example.autumn_valley_agriculture.pojo.Goodstype;
import com.example.autumn_valley_agriculture.pojo.Userinfo;
import com.example.autumn_valley_agriculture.service.BusinesssysService;
import com.example.autumn_valley_agriculture.util.PageUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusinesssysServiceImpl implements BusinesssysService {

    @Autowired
    private BusinesssysMapper businesssysMapper;

    @Override
    public Userinfo validate(String user, String pwd) throws JsonProcessingException {
        return businesssysMapper.validate(user,pwd);
    }

    @RemoveKey(CacheKey.HD_getUser)
    public void del(){

    }

    @Override
    public Userinfo selUser(String user) {
        System.out.println(user);
        return businesssysMapper.selUser(user);
    }

    @Override
    public List<Userinfo> selNameVal(String val) {
        return businesssysMapper.selNameVal(val);
    }

    @Override
    public PageInfo<Userinfo> getCurrentPageUserInfo(Integer currentPage, Integer pageSize,String val) {
        List<Userinfo> allBooks=null;
        if (val==null){
            allBooks= businesssysMapper.getPuser();
        }else{
            allBooks= businesssysMapper.selNameVal(val);
        }

        PageInfo page = new PageUtil<Userinfo>().getPage(currentPage, pageSize, allBooks);
        return page;
    }

    @Override
//    @RemoveKey(CacheKey.HD_getUser)
    public int addUserInfo(Userinfo userinfo) {
        return businesssysMapper.addUserInfo(userinfo);
    }

    @Override
    public PageInfo<Goodstype> getPageGoodstype(Integer currentPage, Integer pageSize) {
        List<Userinfo> pGoodsType = businesssysMapper.getPGoodsType();
        PageInfo page = new PageUtil<Userinfo>().getPage(currentPage, pageSize, pGoodsType);
        return page;
    }
}
