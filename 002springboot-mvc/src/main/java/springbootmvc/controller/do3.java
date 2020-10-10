package springbootmvc.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;


@RestController
public class do3 {
    @RequestMapping("/do4")
    public String do4(RequestParameter param){
        return "request param"+param.toString();
    }
    @RequestMapping("/do5")
    public String  do5(@RequestParam Map<String,Object> param){
       return "request param"+param.toString();
    }
}
