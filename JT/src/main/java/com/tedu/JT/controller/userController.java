package com.tedu.JT.controller;

import com.tedu.JT.mapper.UserMapper;
import com.tedu.JT.pojo.User;
import com.tedu.JT.pojo.UserExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class userController {
    @Autowired
    UserMapper userMapper;

    @RequestMapping("/user/register")
    @CrossOrigin
    public String register(User user) {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.or();
//        设置查询条件
        criteria.andUsernameEqualTo(user.getUsername());
//执行查询
        List<User> userList = userMapper.selectByExample(userExample);
        if (userList != null && userList.size() == 0) {//没有查询到用户
//            保存用户
            int rowcount = userMapper.insert(user);
            if (rowcount >= 1) {
                return "注册成功";
            } else {
                return "注册失败";
            }

        } else {
            return "用户已经存在";
        }
    }

    @RequestMapping("/user/login")
    @CrossOrigin
    public String login(User user) {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.or();
        criteria.andUsernameEqualTo(user.getUsername());
        criteria.andPasswordEqualTo(user.getPassword());
        List<User> userList = userMapper.selectByExample(userExample);
        if (userList != null && userList.size() >= 1) {
            User user1 = userList.get(0);
            user1.setPassword("");
            return "登录成功";
        } else {
            return "登录失败";
        }

    }
}
