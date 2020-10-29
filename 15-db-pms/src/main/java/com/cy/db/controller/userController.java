package com.cy.db.controller;

import com.cy.db.pojo.user;
import com.cy.db.service.userService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class userController {
    @Autowired
    private userService   u;
//    密码修改
@RequestMapping("doUpdatePassword")
public JsonResult doUpdatePassword(
        String pwd,
        String newPwd,
        String cfgPwd) {
    u.updatePassword(pwd, newPwd, cfgPwd);
    return new JsonResult("update ok");
}
//授权登录
    @RequestMapping("doLogin")
    public JsonResult doLogin(String username,String password,boolean isRememberMe){
        System.out.println("==login==");
        //1.获取Subject对象
        Subject subject= SecurityUtils.getSubject();
        //2.通过Subject提交用户信息,交给shiro框架进行认证操作
        //2.1对用户进行封装
        UsernamePasswordToken token=
                new UsernamePasswordToken(
                        username,//身份信息
                        password);//凭证信息
//记住我配置
        if(isRememberMe){
         token.setRememberMe(true);
        }
        //2.2对用户信息进行身份认证
        subject.login(token);
        //分析:
        //1)token会传给shiro的SecurityManager
        //2)SecurityManager将token传递给认证管理器
        //3)认证管理器会将token传递给realm
        return new JsonResult("login ok");
    }
//    user用户数据更新
    @RequestMapping("doUpdateObject")
    public JsonResult doUpdate(user entity ,Integer[] roleIds){
        u.updateObject(entity, roleIds);
        return  new JsonResult("update OK");

    }
//    用户id查询
    @RequestMapping("doFindObjectById")
    public JsonResult doFindById(Integer id){
        Map<String, Object> map = u.findObjectById(id);
        return new JsonResult(map);
    }

//添加用户
    @RequestMapping("doSaveUser")
    public  JsonResult doSaveUser(user entity, Integer[] roleIds){
        int i = u.saveObjectUser(entity, roleIds);
        return  new JsonResult("save OK");
    }
//    user的状态修改
    @RequestMapping("doValidById")
    public JsonResult doValid(Integer id,Integer valid){
            u.validById(id,valid);
            return new JsonResult("update ok");
    }
//    分页查询
    @RequestMapping("doFindPageObject")
    public  JsonResult doFindPageObjects(String username,Integer pageCurrent){
          return new JsonResult(u.findPageObject(username,pageCurrent));
    }
}
