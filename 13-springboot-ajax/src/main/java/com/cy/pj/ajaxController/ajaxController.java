package com.cy.pj.ajaxController;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ajaxController {
    private List<String>   list=new ArrayList<>();//假设则是存储名字的数据库
    @PostMapping("doSave")
    public  String doSave(String name){
        list.add(name);
        return "save ok";
    }
    @RequestMapping("/doCheck")
    public  String doCheck(String name){
        return  list.contains(name)?name+"已经存在":name+"可注册";
    }
    @GetMapping("doAjax")
    public String doAjax() throws InterruptedException {
        System.out.println("===doAjaxGet()");
        Thread.sleep(5000);
        return "ajax  request  result";
    }
}
