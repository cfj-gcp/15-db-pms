package com.cy.health.controller;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
@Controller
public class HealthController {//Handler(通过此对象处理dispatcherServlet分法过来的请求)
    @RequestMapping("/doHealth")
    public ModelAndView doHealth(){
        ModelAndView  mv=new ModelAndView();
        mv.setViewName("default");
        mv.addObject("username", "是个猪");
        mv.addObject("state", "是个狗");

        return  mv;
        //1.返回值会交给DispatcherServlet对象进行处理
        //2.DispatcherServlet对象会调用viewresolver对结果进行解析
        //2.1基于viewname找到对应的view页面(prefix+viewname+suffix)
        //2.2将model中的数据填充到view页面上
        //2.3返回一个带有module数据的页面给DispatcherServlet
        //3.DispatcherServlet将带有model数据的页面响应到客户端

    }
    @RequestMapping("/doJson")
    @ResponseBody//当时用次注解时描述控制层方法时，用于告诉spring框架这个返回值尽量为json串响应的格式
    public Map<String,Object> doJson() {
        Map<String, Object> map = new HashMap<>();
        map.put("username", "tony");
        map.put("state", true);
        return map;
    }
    @RequestMapping("/doPrint")
//    @ResponseBody
    public  void  doPrint(HttpServletResponse response) throws IOException {
//        System.out.println("do==print");
        HashMap<String, Object> map = new HashMap<>();
        map.put("username","李二狗");
        ObjectMapper mapper = new ObjectMapper();
        String s = mapper.writeValueAsString(map);
        System.out.println("json"+s);
//        将字符串响应到客户端
       response.setCharacterEncoding("utf-8");
        response.setContentType("html/text;charset=utf-8");
        response.getWriter().println(s);
    }
}
