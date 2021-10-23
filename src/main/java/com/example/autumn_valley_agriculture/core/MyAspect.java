package com.example.autumn_valley_agriculture.core;

import com.example.autumn_valley_agriculture.util.JacksonUtil;
import com.example.autumn_valley_agriculture.util.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Aspect//表示这是切面类
@Component
@Slf4j
public class MyAspect {

    @Autowired
    private RedisUtil redisUtil;
    //定义切点
    //??:如何切到只包含@RedisCache注解的方法
    @Pointcut("execution(* com.example.autumn_valley_agriculture.service.impl.*.*(..))&& @annotation(com.example.autumn_valley_agriculture.core.RedisCache)")
    public  void PC_Cache(){};

    @Pointcut("execution(* com.example.autumn_valley_agriculture.service.impl.*.*(..))&& @annotation(com.example.autumn_valley_agriculture.core.RemoveKey)")
    public void PC_Remove(){};

    //老师  处理Redis缓存的方法
    @Around("PC_Cache()")
    public Object Around(ProceedingJoinPoint pjp){
        Object proceed=null;
        try {
            //前置通知
            String key = ((MethodSignature) pjp.getSignature()).getMethod().getAnnotation(RedisCache.class).value().toString();
            String json = (String)redisUtil.get(key);
            if (json != null) {
                //获得将被调用方法的返回类型
                Class<?> returnType = ((MethodSignature) pjp.getSignature()).getMethod().getReturnType();
                Object o = JacksonUtil.toObject(json, returnType);
                log.warn("redis返回数据");
                return o;
            }
            proceed = pjp.proceed();
            if(proceed!=null){
                //返回通知
                String s = JacksonUtil.toJson(proceed);
                redisUtil.set(key,s);
            }
        } catch (Throwable e) {
            e.printStackTrace();
            //异常通知
        }finally {
            //最终通知
        }
        log.warn("数据库返回数据");
        return proceed;
    }

    //移除redis缓存
    @AfterReturning("PC_Remove()")
    public void aroundRemove(JoinPoint joinPoint){
            String key = ((MethodSignature) joinPoint.getSignature()).getMethod().getAnnotation(RemoveKey.class).value().toString();
            redisUtil.removeKey(key);
    }







//    //定义通知
//    @Before("PC_Cache()&&target(target)")
//    public  void  before(JoinPoint joinPoint,Object target){
//        RedisCache annotation = ((MethodSignature) joinPoint.getSignature()).getMethod().getAnnotation(RedisCache.class);
//        String value=annotation.value();
//        System.out.println(value);
//        //??:如何获得@RedisCache注解里的value
//
//        //从Redis获得了数据,数据如何返回?
//        System.out.println(joinPoint.getSignature().getName()+"被调用了");
//        System.out.println("目标对象实例是" + target);
//    }
//    @AfterReturning(value = "PC_Cache()",returning = "returnValue")
//    public  void  afterreturning(JoinPoint joinPoint,Object returnValue){
//        System.out.println(joinPoint.getSignature().getName()+"的返回值是"+returnValue);
//        //用redis保存
//    }

    //自己
//    @Around("PC_Cache()")
//    public Object Around1(ProceedingJoinPoint pjp){
////        获取方法名
//        try {
//            System.out.println(pjp.getSignature().getName());
//
//            Signature signature = pjp.getSignature();
//
//            //获取@RedisCache注解的value
//            String key = ((MethodSignature) pjp.getSignature()).getMethod().getAnnotation(RedisCache.class).value().toString();
//            System.out.println(key);
//            //获得方法的返回类型
//            Class<?> returnType = ((MethodSignature) pjp.getSignature()).getMethod().getReturnType();
//            System.out.println(returnType);
//            //实例化
////            Object o = returnType.newInstance();
//
//            ObjectMapper mapper=new ObjectMapper();
//            String json = (String)redisUtil.get(key);
//            if (json != null) {
//                System.out.println("redis拿数据");
//                return  mapper.readValue(json, returnType);
////                return  mapper.readValue(json, ArrayList.class);
//            }else {
//                    Object result = pjp.proceed();
//                    redisUtil.set(key, mapper.writeValueAsString(result));
//                System.out.println("数据库拿数据");
//                    return result;
//            }
//        } catch (Throwable throwable) {
//            throwable.printStackTrace();
//            return null;
//        }
//    }

}
