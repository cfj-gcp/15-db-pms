package com.tedu.JT.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Test {
    @RequestMapping("/name")
    public  String  name(){
       return "就这样吧";
    }
}
