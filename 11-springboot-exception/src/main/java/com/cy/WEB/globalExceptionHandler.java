package com.cy.WEB;


import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

//@ResponseBody
//@ControllerAdvice//次注解描述web层面的全局异常处理
@RestControllerAdvice
public class globalExceptionHandler {
    @ExceptionHandler(ArithmeticException.class)
//    @ResponseBody
    public String doHandleArithmeticException(ArithmeticException e){
        e.printStackTrace();
        System.out.println("C:\\Users\\soft\\Desktop\\JT\\11-springboot-exception\\src\\main\\java\\com\\cy\\WEB\\globalExceptionHandler.java");
        System.out.println("com/cy/WEB/globalExceptionHandler.java");
        return "计算过程中出现了异常，异常信息为："+e.getMessage();
    }
    @ExceptionHandler(Throwable.class)
//    @ResponseBody
    public String doHandleArithmeticException(Throwable e){
        e.printStackTrace();
//        发邮件，发短信，后台服务器报警
        return "系统维护中";
    }
}
