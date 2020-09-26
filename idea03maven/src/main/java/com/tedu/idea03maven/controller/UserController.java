package com.tedu.idea03maven.controller;
//处理主站用户注册登录

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;
import com.tedu.idea03maven.mapper.UserMapper;
import com.tedu.idea03maven.pojo.ItemExample;
import com.tedu.idea03maven.pojo.User;
import com.tedu.idea03maven.pojo.UserExample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController

public class UserController {
//    从spring容器中获取usermapper的代理对象
    @Autowired
    UserMapper  userMapper;
//    完成登录
    @RequestMapping("/user/login")
    @CrossOrigin//允许任何网站通过javascript访问
  public User  login(User user){
//        where  username=admin and password=admin
//        使用UserExample.criteria生成where
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.or();
//        设置查询条件
        criteria.andUsernameEqualTo(user.getUsername());
        criteria.andPasswordEqualTo(user.getPassword());
        List<User> userList = userMapper.selectByExample(userExample);
        if (userList!=null && userList.size()>=1){
            User returnUser = userList.get(0);
            returnUser.setPassword("");
            return  returnUser;
        }
        return  null;
    }

//    完成注册
    @RequestMapping("/user/register")
    @CrossOrigin//允许任何网站通过javascript访问
    public  String register(User user){
//     查询User表用户是否存在
//        select * from user where username=admin
//        使用userExample生成where
//        UserExample是逆向工程生成的
        UserExample userExample = new UserExample();
//        UserExample有个内部类Criteria
        UserExample.Criteria criteria =userExample.or();
//        设置查询条件
        criteria.andUsernameEqualTo(user.getUsername());
//执行查询
        List<User> userList =userMapper.selectByExample(userExample);
//        判断集合中是否有数据
        if(userList!=null && userList.size()==0){
//            用户名不存在，板寸用户信息到user表中
            int rowCount = userMapper.insert(user);
            if(rowCount>=1){
                return "注册成功";
            }else {
                return "注册失败";
            }
        }else{
            return "用户已存在";
        }

    }
}
