package com.cy.db.service;

import com.cy.db.pojo.roleMenu;
import com.cy.db.pojo.role;
import com.cy.db.pojo.userRole;
import com.cy.db.pojo.page;

import java.util.List;

public interface roleService {
//    用户角色信息
    List<userRole> findUserRole();
//    更新角色数据
int updateObject(role entity, Integer[] menuIds);
//    修改角色和对应的权限,先查询出对应的数据
       roleMenu  findById(Integer id);
//    角色保存和对应的权限表menu
    int saveObject(role entity, Integer[] menuIds);
//    角色分页
    page<role> findPageObject(String name, Integer pageCurrent);
}
