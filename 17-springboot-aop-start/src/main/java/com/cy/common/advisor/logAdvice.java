package com.cy.common.advisor;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
//封装了扩展逻辑的对象
public class logAdvice implements MethodInterceptor {
//    此方法可以在目标业务方法执行之间和之后添加扩展逻辑
    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        System.out.println("start"+System.nanoTime());
        Object result = methodInvocation.proceed();//执行目标方法
        System.out.println("end"+ System.nanoTime());
        return result ;
    }
}
