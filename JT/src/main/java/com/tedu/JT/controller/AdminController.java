package com.tedu.JT.controller;

import com.tedu.JT.mapper.AdminMapper;
import com.tedu.JT.pojo.Admin;
import com.tedu.JT.pojo.AdminExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//处理后台管理员的相关请求
@RestController
public class AdminController {
    @Autowired
   AdminMapper  adminMapper;
    @RequestMapping("/admin/login")
    @CrossOrigin
    public String  login(Admin admin){
        AdminExample adminExample = new AdminExample();
        AdminExample.Criteria criteria = adminExample.or();
        criteria.andAdminNameEqualTo(admin.getAdminName());
        criteria.andAdminPasswordEqualTo(admin.getAdminPassword());
        List<Admin> adminList = adminMapper.selectByExample(adminExample);
        if (adminList!=null&&adminList.size()>=1) {
            Admin admin1 = adminList.get(0);
            return "登录成功";
        }else{
           return "登录失败" ;
        }
        }
    }


