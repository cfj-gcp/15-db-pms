package springbootmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ModulViewController {//此方法由DispatcherServlet对象通过反射调用
    @RequestMapping("/domodule")
    public  String  module1(Model  model){
         model.addAttribute("username","jason");
         model.addAttribute("state",true);
         return "do";
        //1.返回值会交给DispatcherServlet对象进行处理
        //2.DispatcherServlet对象会调用viewresolver对结果进行解析
        //2.1基于viewname找到对应的view页面(prefix+viewname+suffix)
        //2.2将model中的数据填充到view页面上
        //2.3返回一个带有module数据的页面给DispatcherServlet
        //3.DispatcherServlet将带有model数据的页面响应到客户端

    }
}
