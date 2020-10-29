package com.cy.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Aspect
@Component
public class CacheAspect {
    //假设这个map就是我们的一个小cache，我们从数据库取出的数据可以存储到此cache
    private Map<String,Object> cache=new ConcurrentHashMap<>();

    @Pointcut("bean(moduleImpl)")//注意首字母大小写的问题
    public void doCache(){}

    @Around("doCache()")
    public Object around(ProceedingJoinPoint joinPoint)throws Throwable{
        //1.从cache取数据
        Object obj=cache.get("userPer");//这里假设key为userPer
        if(obj!=null)return obj;
        //2.cache中没有则查数据
        obj=joinPoint.proceed();
        //3.将数据存储到cache
        cache.put("userPer", obj);
        return obj;
    }
    //.....


}
