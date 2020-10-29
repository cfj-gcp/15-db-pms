package com.cy.db.Dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface userRoleDao {
//    删除用户角色信息
    int deleteObjects(Integer userId);
//    根据用户Id查询角色集合
    List<Integer>  findRoleByUserId(Integer id);
//    添加用户角色信息
    int  insertObjects(@Param("userId")Integer userId,
                       @Param("roleIds")Integer[] roleIds);
}
