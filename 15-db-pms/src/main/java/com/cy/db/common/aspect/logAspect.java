package com.cy.db.common.aspect;

import com.cy.db.common.until.IPUtils;
import com.cy.db.common.annotation.RequiredLog;
import com.cy.db.pojo.log;
import com.cy.db.service.logService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.lang.reflect.Method;
import java.util.Date;
//@Order(1)
@Slf4j
@Component
@Aspect//注解描述对象为一个切面对象//point切入点：织入扩展功能的一些连接结合点、、advice：通知方法封装了扩展逻辑的方法
public class logAspect {
   //通过Pointcut定义一个切入点，@annotation方式为定义切入点的一种方式
   //在这里表示业务对象有com.cy.db.common.annotation.RequiredLog注解描述的方法为一些切入点
   @Pointcut("@annotation(com.cy.db.common.annotation.RequiredLog)")
   public  void doLog(){};//doLog方法仅仅是@Poincut注解的一个载体，

   /**
    * @Around注解描述的方法可以再目标方法执行之前和之后做功能扩展
    * @param joinPoint 封装了目标方法信息的一个对象（连接点对象）
    * @return 目标方法执行的结果
    * @throws Throwable
    */
   @Around("doLog()")
   public Object doAround(ProceedingJoinPoint joinPoint) throws  Throwable{
     try {

        long t1=System.currentTimeMillis();
        Object result = joinPoint.proceed();//去调用目标方法，其返回值为目标方法的返回值
        long t2 = System.currentTimeMillis();
        System.out.println("tiem:"+(t2-t1));
//      将正常的用户行为写入到数据库中
        saveServiceLog((t2-t1), joinPoint);
        return result;
     }catch (Throwable e){
//        log.error("msg->{}",e.getMessage());
        logError(joinPoint,e.getMessage());
           throw e;
     }
   }
   private  void logError(ProceedingJoinPoint joinPoint,String exception) throws JsonProcessingException {
           String targetClassName=joinPoint.getTarget().getClass().getName();
           String methodName=joinPoint.getSignature().getName();
           String params=new  ObjectMapper().writer().writeValueAsString(joinPoint.getArgs());
           log.error("msg->-{}->{}-{}",targetClassName+"."+methodName,params,exception);
   }
   @Autowired
   private logService  logService;
   private   void  saveServiceLog(long time,ProceedingJoinPoint joinPoint) throws NoSuchMethodException, JsonProcessingException {
//      获取用户的行为日志
//      获取目标对象类型
      Class<?> targetClass = joinPoint.getTarget().getClass();
//      获取目标方法的签名信息
      MethodSignature ms = (MethodSignature)joinPoint.getSignature();
//      获取目标方法？（类中方法的唯一标识：方法名+参数列表）
      Method targetMethod = targetClass.getDeclaredMethod(ms.getName(), ms.getParameterTypes());
//      获取requiredlog
      RequiredLog annotation = targetMethod.getAnnotation(RequiredLog.class);
//      获取操作名Requiredlog中的值
      String  operation=annotation.value();
//      封装日志的信息
      log entity = new log();
      entity.setUsername("cgb");
      entity.setIp(IPUtils.getIpAddr());
         entity.setOperation(operation);//为目标方法指定一个名字
         entity.setMethod(targetClass.getName()+"."+targetMethod.getName());//类全名+方法名
//         entity.setParams(Arrays.toString(joinPoint.getArgs()));
      entity.setParams(new ObjectMapper().writeValueAsString(joinPoint.getArgs()));
         entity.setTime(time);
         entity.setCreatedTime(new Date());
//         保存用户行为值
//      logService.SaveObject(entity);
      new Thread(){
         @Override
         public void run() {
            super.run();
            logService.SaveObject(entity);
         }
      }.start();
   }
}
