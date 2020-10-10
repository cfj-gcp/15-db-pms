package springbootmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TemplateController {
 @RequestMapping("/doit")
    public String  doit(){
    return "do";
    }
}
