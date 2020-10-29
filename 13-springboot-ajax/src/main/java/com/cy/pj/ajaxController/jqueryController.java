package com.cy.pj.ajaxController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class jqueryController {
    @RequestMapping("loader")
    public String loader(String msg){
        return "向天打飞机"+msg;
    }
    //@RequestBody 描述方法参数时,表示这个参数的值来自客户端post提交的json字符串
    @PostMapping("doPostJSON")
    public String doPostJSON(@RequestBody Map<String,Object> map){
        System.out.println("map="+map);
        return "post ok";
    }
    //使用map作为参数接收请求参数时，要使用@RequestParam注解对参数进行修饰
    @PostMapping("doPost")
    public  String doPost(@RequestParam Map<String,Object> map){//使用map作为参数接收请求时，
        // 要使用@requestParam注解修饰
        System.out.println("map="+map);
        return "post ok";
    }
    @GetMapping ("doGet")
     public Map<String,Object> doGet(){
        HashMap<String, Object> map = new HashMap<>();
        map.put("message", "sucess");
        map.put("code", "1");
        return map;
    }
    @RequestMapping("doJqueryAjax")
public String  doAjax(String msg){
        System.out.println("mesg:"+msg);
 return msg+".toUpperCase():"+msg.toUpperCase();
}
}
