package com.cy.db.common.web;
import com.cy.db.common.exception.serviceException;
import org.springframework.web.servlet.HandlerInterceptor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalTime;

//spring mvc 中的拦截器
public class TimeAccessInterceptor  implements HandlerInterceptor {
//    此方法再我们的后端controller方法执行之前执行
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("=preHandle");
        LocalTime time = LocalTime.now();//jdk8中的api
        int hour = time.getHour();
        System.out.println("hour="+hour);
        if(hour<7||hour>18){
          throw new serviceException("不在登陆时间范围内");
        }
        return true;//true表示放行，false表示请求到此结束
    }
}
