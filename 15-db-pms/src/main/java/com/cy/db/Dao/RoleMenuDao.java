package com.cy.db.Dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface RoleMenuDao {
//    基于角色id查找所有菜单id查找菜单id
    List<Integer> findMenuIdsByRoleIds(@Param("roleIds")List<Integer> roleIds);
//    基于角色id查询权限菜单信息
    @Select("select menu_id from sys_role_menus  where role_id=#{roleId}")
    List<Integer> findByRoleId(Integer roleId);
//    角色菜单插入
    int insertObjects(@Param("roleId") Integer roledId, @Param("menuIds") Integer[] menuIds);
    //    基于菜单id执行关系数据的删除
    @Delete("delete from sys_role_menus  where role_id=#{menuId}")
    int  deleteObjectByRoleId(Integer menuId);
//    基于菜单id执行关系数据的删除
    @Delete("delete from sys_role_menus  where menu_id=#{menuId}")
    int  deleteObjectByMenuId(Integer menuId);
}

