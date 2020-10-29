package com.cy.db.common.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class aspectTime {
    @Pointcut("bean(logServiceImpl)")
    private   void doTime(){

    }
    @Before("doTime()")
   public  void  doBefore(){
       System.out.println("@before");
   }
    @After("doTime()")
   public  void  doAfter(){
       System.out.println("@After");
   }
    @AfterReturning("doTime()")
   public  void  doAfterReturning(){
       System.out.println("@AfterReturning");
   }
    @AfterThrowing("doTime()")//出现异常执行
   public  void  doAfterThrowing(){
       System.out.println("@AfterThrowing");
   }
   @Around("doTime()")
   public  Object doAround(ProceedingJoinPoint jo) throws Throwable {
      try {
          System.out.println("@Around.before");
          Object result = jo.proceed();
          System.out.println("@Around.after");
            return  result;
      }catch (Throwable e){
          System.out.println("@Arount.exception");
          throw  e;
      }
   }
}
