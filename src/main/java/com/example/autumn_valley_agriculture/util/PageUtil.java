package com.example.autumn_valley_agriculture.util;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;

import java.util.List;

public class PageUtil<T> {
    public PageInfo getPage(Integer currentPage, Integer pageSize, List<T> resultList){
        Page page =new Page(currentPage,pageSize);
        page.setTotal(resultList.size());
        int startIndex = (currentPage-1)*pageSize;
        int endIndex = Math.min(resultList.size(),startIndex+pageSize);
        page.addAll(resultList.subList(startIndex,endIndex));
        return new PageInfo(page);
    }
}
