package com.cy.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component//表示在spring中做一个注册
@Aspect//告诉spring这是一个切面对象，这样的对象主要包含两部分内容（1.切点2.扩展逻辑 advice）
public class aspect {

    //    定义切入点
//    bean表达式为spring中的一种粗粒度切入点表达式（不能精确到具体位置，具体方法）
//    这里的mailServiceImpl名字为spring容器中一个bean对象的名字
    @Pointcut("bean(mailServiceImpl)")
    public void doLogPointCut() {
    }//这个方法仅仅是承载切入点注解的一个载体，方法体内不需要写任何内容
    /**按照Aspect规范定义一个@Around通知*/
    //@Around("bean(mailServiceImpl)") //直接在advice注解内部定义切入点表达式

    /**
     * 按照Aspect规范定义一个@Around通知
     */
    //@Around("bean(mailServiceImpl)") //直接在advice注解内部定义切入点表达式
    @Around("doLogPointCut()")//也可以在advice注解内部通过方法引用切入点表达式。
    //对于@Around注解描述的方法其规范要求：
    //1)返回值类型为Object (用于封装目标方法的执行结果)
    //2)参数类型ProceedingJoinPoint (用于封装要执行的目标方法信息)
    //3)抛出的异常为Throwable (用于封装执行目标方法时抛出的异常)
    //4)在@Around注解描述的方法内部,可以手动调用目标方法
    public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {
        long t1 = System.nanoTime();
        Object result = joinPoint.proceed();//表示调用目标方法
        long t2 = System.nanoTime();
        System.out.println("SysLogAspect->Time->" + (t2 - t1));
        return result;
    }

}