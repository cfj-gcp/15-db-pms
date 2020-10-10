package com.cy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;



@Controller
public class ModuleController {
    @RequestMapping("request/{n1}/{n2}")
    @ResponseBody
    public  String doHandleRequest(@PathVariable Integer n1, @PathVariable Integer n2){

//        try {
        Integer result=n1/n2;
        return  "result is"+result;
//        }
//        catch (java.lang.ArithmeticException e){
//            e.printStackTrace();
//            return "除数不能为0";
//       }
    }
//    局部异常处理
//    @ExceptionHandler(ArithmeticException.class)
//    @ResponseBody
//    public String doHandleArithmeticException(ArithmeticException e){
//        e.printStackTrace();
//        return "计算过程中出现了异常，异常信息为："+e.getMessage();
//    }
}
