package springbootmvc.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Param {
    @RequestMapping("/DO")
    public  String  DO(String name){
        return "request params"+name;
    }
}
