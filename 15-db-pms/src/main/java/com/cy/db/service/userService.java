package com.cy.db.service;

import com.cy.db.pojo.user;
import com.cy.db.pojo.userDept;
import com.cy.db.pojo.page;

import java.util.Map;

public interface userService {
//     修改用户密码
int updatePassword(String password,
                   String newPassword,
                   String cfgPassword);
//     更新用户
     int updateObject(user entity,Integer[] roleIds);
//     根据用户id查询信息
     Map<String,Object> findObjectById(Integer userId);
//     添加用户
     int saveObjectUser(user entity ,Integer[] roleIds);
//     修改user禁用状态
     int validById(Integer id,Integer valid);
//     分页查询
     page<userDept> findPageObject(String username, Integer pageCurrent);
}
