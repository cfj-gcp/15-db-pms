package com.cy.db.controller;
import com.cy.db.pojo.leftMenu;
import com.cy.db.pojo.user;
import com.cy.db.service.menuServic;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
@Controller
public class pageController {
    @Autowired
    private menuServic menuServic;
//    @RequestMapping("doMenuUI")
//    public  String   doMenuUI(){
//        return  "sys/menu_list";
//    }
//    @RequestMapping("logList")
//    public String doLogUI(){
//        return "sys/log_list";
//    }
    @RequestMapping("{modul}/{moduleUI}")
    public String doModuleUI( @PathVariable  String moduleUI){
        return "sys/"+moduleUI;
    }
    @RequestMapping("doIndexUIFirst")
    public  String   doIndexUI(Model  model){
//       获取登录用户
        user user = (user)SecurityUtils.getSubject().getPrincipal();
        String  username=user.getUsername();
 model.addAttribute("username",username );
// 左侧菜单
        List<leftMenu> userMenus = menuServic.findUserMenusByUserId(user.getId());
        model.addAttribute("userMenus", userMenus);
        return  "starter";
    }
    @RequestMapping("doLoginUI")
    public  String   doLoginUI(){
        return  "login";
    }
    @RequestMapping("pageUI")
    public  String doPageUI(){
        return "common/page";
    }
}
