package com.example.autumn_valley_agriculture.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JacksonUtil {

    private static ObjectMapper objectMapper;

    //懒加载
    private static ObjectMapper mapper(){
        if (objectMapper==null)objectMapper=new ObjectMapper();
        return objectMapper;
    }

    public static <T> T toObject(String json,Class<T> t){
        T o=null;
        try {
            o = (T) mapper().readValue(json, t);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return o;
    }

    public static String toJson(Object obj){
        String str=null;
        try {
            str = mapper().writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return str;
    }

}
