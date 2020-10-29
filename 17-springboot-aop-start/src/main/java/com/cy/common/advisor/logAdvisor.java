package com.cy.common.advisor;

import org.springframework.aop.support.StaticMethodMatcherPointcutAdvisor;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * 此advisor中定义了一种规范
 * 定义了那些方法为切入点方法
 * 定义了在切入点方法执行时要扩展的逻辑
 */
@Component
public class logAdvisor  extends StaticMethodMatcherPointcutAdvisor {
    public logAdvisor(){
     setAdvice(new logAdvice());
    }
    /**matches方法中可以获取我们要执行的目标方法，并且我们可以在此定义这个目标方法是否为我们的一个切入点方法
     *1)返回值为true表示目标方法为切入点方法(在此方法执行时可以织入扩展逻辑)
     *2)返回值为false表示目标方法为非切入点方法 */
    @Override
    public boolean matches(Method method, Class<?> aClass) {
        try {
            Method declaredMethod = aClass.getDeclaredMethod(method.getName(), method.getParameterTypes());
            return  declaredMethod.getName().equals("sendMail");
        }catch (Exception e){
            return false;
        }
    }
}
