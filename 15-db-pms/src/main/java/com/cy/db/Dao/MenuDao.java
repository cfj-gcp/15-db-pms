package com.cy.db.Dao;

import com.cy.db.pojo.leftMenu;
import com.cy.db.pojo.menu;
import com.cy.db.pojo.node;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.awt.*;
import java.util.List;
import java.util.Map;

@Mapper
public interface MenuDao {
//    左侧菜单  基于菜单id获取菜单相关信息
List<leftMenu> findMenusByIds(
        @Param("menuIds")List<Integer> menuIds);
    //    基于菜单id查找授权标识
    List<String>  findpermissions(@Param("menuIds")List<Integer> menuIds);
//    修改菜单信息
int updateObject(menu entity);
//    插入才菜单信息
    int insertObject(menu entity);
//    添加菜单查询节点
    @Select("select id,name,parentId from sys_menus")
    List<node> findZtreeMenuNodes();
//    删除菜单信息
    @Delete("delete from sys_menus where id=#{id}")
    int deleteObject(Integer id);
//    先查询菜单子菜单关系
    @Select("select count(*) from sys_menus where parentId=#{id}")
    int getChildCount(Integer id);

//    查询所有菜单信息
    List<Map<String,Object>> findObject();
}
