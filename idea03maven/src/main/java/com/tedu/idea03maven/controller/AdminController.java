package com.tedu.idea03maven.controller;

import com.tedu.idea03maven.mapper.AdminMapper;
import com.tedu.idea03maven.pojo.Admin;
import com.tedu.idea03maven.pojo.AdminExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//处理后台管理中的管理员的相关请求
@RestController
public class AdminController {
    @Autowired
    AdminMapper  adminMapper;
//    管理员登录
    @RequestMapping("/admin/login")
    @CrossOrigin//允许任何网站通过javascript访问
    public Admin login(Admin admin){
//        whre adminName="root" and adminPasword="root"
        AdminExample adminExample = new AdminExample();
        AdminExample.Criteria  criteria= adminExample.or();
        criteria.andAdminNameEqualTo(admin.getAdminName());
        criteria.andAdminPasswordEqualTo(admin.getAdminPassword());
        List<Admin> adminList = adminMapper.selectByExample(adminExample);
        if(adminList!=null &&adminList.size()>=1){
            Admin returnAdmin = adminList.get(0);//取集合的第一个数据
            return  returnAdmin;
        }
        return  null;
    }
}
